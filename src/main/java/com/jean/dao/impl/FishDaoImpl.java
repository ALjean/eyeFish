package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.*;
import com.jean.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Repository
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

    private static final Logger log = LoggerFactory.getLogger(FishDaoImpl.class);

    @Override
    public void save(AbstractFish fish) throws CustomDfmException, SQLException {

        String sqlFish = "INSERT INTO fish (name, description, type, living_area) VALUES (?, ?, ?, ?)";
        String sqlWeatherStateParam = "INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value) VALUES (?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        int idFish = -1;
        int rowInsert;

        try {

            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlFish, Statement.RETURN_GENERATED_KEYS);

            setNibbleStateParamToPs(preparedStatement, fish);

            rowInsert = preparedStatement.executeUpdate();

            if (rowInsert == 0) {
                throw new SQLException("Creating fish failed, no rows affected.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idFish = generatedKeys.getInt(1);
            }

            preparedStatement = connection.prepareStatement(sqlWeatherStateParam);

            for (FishParameters stateParam : fish.getFishParams()) {
                setNibbleStateParamToPs(preparedStatement, stateParam, idFish);
            }

            rowInsert = preparedStatement.executeUpdate();

            if (rowInsert == 0) {
                throw new SQLException("Creating Weather State failed, no rows affected.");
            }

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw new CustomDfmException(e, "some problem with save fish");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        log.info("Fish model save with id: " + idFish);

    }

    @Override
    public AbstractFish read(int id) throws CustomDfmException {

        String sql = "SELECT f.name, f.description, f.type, fp.id, fp.fish_id, fp.state_data_type, fp.min_range_value, fp.max_range_value, fp.result_nibble_value\n"
                + "FROM fish f INNER JOIN  fish_parameters fp ON f.id = fp.fish_id WHERE f.id = ?";

        AbstractFish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            List<FishParameters> fishParams = new ArrayList<FishParameters>();

            while (rs.next()) {

                fish = getFishFromRs(rs);
                fish.setFishParams(fishParams);

                fishParams.add(getNibbleStateParamFromRs(rs));

            }
            log.info(fish != null ? fish.toString() : "Fish by id not found");

        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem when you try read fish");
        }

        return fish;
    }

    @Override
    public AbstractFish update(AbstractFish fish) {
        // TODO field type FK
        String sql = "UPDATE fish f INNER JOIN weather_state ws ON f.id = ws.fish_id "
                + "SET f.name = ?, f.description = ?, f.type = ?, ws.max = ?, ws.min = ?, ws.nibble = ?, ws.type_data_weather = ?";
        return null;
    }

    @Override
    public void delete(int id) throws CustomDfmException, SQLException {
        List<Integer> typesFish = new ArrayList<>();
        Connection connection = getConnection();

        String sqlSelectTypes = "SELECT id FROM weather_state WHERE fish_id = ?";
        String sqlRemoveFishType = "DELETE FROM weather_state WHERE id = ?";
        String sqlRemoveFish = "DELETE FROM fish WHERE id = ?";

        try {
            connection.setAutoCommit(false);

            // get fish's types
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectTypes);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                typesFish.add(rs.getInt(1));
            }

            preparedStatement = connection.prepareStatement(sqlRemoveFishType);

            // create butch for remove types
            for (Integer typeId : typesFish) {
                preparedStatement.setInt(1, typeId);
                preparedStatement.addBatch();
            }

            int[] affectedRecords = preparedStatement.executeBatch();

            log.info("Remove Fish_Type rows: " + affectedRecords.length);

            // remove fish model
            preparedStatement = connection.prepareStatement(sqlRemoveFish);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            connection.commit();

            log.info("Removed Fish with id: " + id);

        } catch (SQLException e) {
            connection.rollback();
            throw new CustomDfmException(e, "Fish remove error");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<AbstractFish> getAllWeather() throws CustomDfmException {
        String sql = "SELECT id fish_id, name, description FROM fish";
        List<AbstractFish> fishes = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                fishes.add(getFishFromRs(rs));
            }

            log.info(fishes.size() > 0 ? "Fish list: " + fishes.size() : "Fish result is zero");

        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem when get List Weather");
        }

        return fishes;
    }

    public AbstractFish getFishByTempForNibble(int temp, int fishId) throws CustomDfmException {

        String sql = "SELECT f.name, f.description, f.type ,ws.id type_data_id, ws.type_data_weather, ws.nibble, ws.min, ws.max, ws.fish_id "
                + "FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id "
                + "WHERE ws.type_data_weather = 'nibbleDataType' AND ws.min <= ? AND ws.max >= ? AND (f.id = ?)";

        AbstractFish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, temp);
            preparedStatement.setInt(2, temp);
            preparedStatement.setInt(3, fishId);

            ResultSet rs = preparedStatement.executeQuery();
            List<FishParameters> nibbleStateParams = new ArrayList<>();

            while (rs.next()) {
                fish = getFishFromRs(rs);
                fish.setFishParams(nibbleStateParams);

                nibbleStateParams.add(getNibbleStateParamFromRs(rs));
                fish.setFishParams(nibbleStateParams);
            }
            log.info(fish != null ? fish.toString() : "Fish by temp not found");

        } catch (SQLException e) {
            throw new CustomDfmException(e, "can't get fish by Temp");
        }

        return fish;
    }

    private FishParameters getNibbleStateParamFromRs(ResultSet rs) throws SQLException {
        FishParameters nibbleStateParam = new FishParameters();
        nibbleStateParam.setId(rs.getInt("type_data_id"));
        nibbleStateParam.setStateDataType(rs.getString("state_data_type"));
        nibbleStateParam.setMinValue(rs.getDouble("min_range_value"));
        nibbleStateParam.setMaxValue(rs.getDouble("max_range_value"));
        nibbleStateParam.setNibble(rs.getLong("result_nibble_value"));
        return nibbleStateParam;
    }

    private AbstractFish getFishFromRs(ResultSet rs) throws SQLException, CustomDfmException {
        AbstractFish fish = FactoryProduser.createFish(rs.getString("type"));
        fish.setId(rs.getInt("fish_id"));
        fish.setDescription(rs.getString("description"));
        fish.setName(rs.getString("name"));
        return fish;
    }

    private void setNibbleStateParamToPs(PreparedStatement preparedStatement, FishParameters fishParam, int idFish) throws SQLException {
        preparedStatement.setInt(1, idFish);
        preparedStatement.setString(2, fishParam.getStateDataType());
        preparedStatement.setDouble(3, fishParam.getMinValue());
        preparedStatement.setDouble(4, fishParam.getMaxValue());
        preparedStatement.setDouble(5, fishParam.getNibble());
    }

    private void setNibbleStateParamToPs(PreparedStatement preparedStatement, AbstractFish fish) throws SQLException {
        preparedStatement.setString(1, fish.getName());
        preparedStatement.setString(2, fish.getDescription());

        if (fish instanceof CalmFish) {
            preparedStatement.setString(3, Constants.FISH_TYPE_CALM);
        }
        if (fish instanceof PredatorFish) {
            preparedStatement.setString(3, Constants.FISH_TYPE_PREDATOR);
        }
		preparedStatement.setString(4, fish.getLivingArea());

    }
}
