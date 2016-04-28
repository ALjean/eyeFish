package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.*;
import com.jean.Constants;
import com.jean.enums.FishTypes;
import com.jean.enums.ParamNames;
import com.jean.util.Log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Repository
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

    private static final Logger log = Logger.getLogger(Log.class);


    public void save(Fish fish) throws DaoDfmException {

        String sqlFish = "INSERT INTO fishes (fish_name, description, type, living_area) VALUES (?, ?, ?, ?)";
        String sqlParam = "INSERT INTO fish_settings (fish_id, name_type, min_value, max_value, nibble_level) VALUES (?, ?, ?, ?, ?)";
        String sqlNibble = "INSERT INTO fish_nibble (fish_id, start_period, end_period, nibble_value) VALUES (?, ?, ?, ?)";


        Connection connection = getConnection();
        PreparedStatement statement = null;
        int idFish;

        try {

            statement = connection.prepareStatement(sqlFish, Statement.RETURN_GENERATED_KEYS);

            setFishStatement(statement, fish);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            idFish = generatedKeys.getInt(1);


            statement = connection.prepareStatement(sqlParam);

            for (FishSetting stateParam : fish.getFishParams()) {
                stateParam.setFishId(idFish);
                addParamsToBatch(stateParam, statement);
            }

            statement.executeUpdate();


            statement = connection.prepareStatement(sqlNibble);

/*            for (FishNibble fishNibble : fish.getNibbles()) {
                fishNibble.setFishId(idFish);
                addNibbleToBatch(fishNibble, statement);
            }*/

            statement.executeUpdate();

            getConnection().commit();

            log.info("Fish model save with id: " + idFish);

        } catch (SQLException e) {
            rollback(connection);
            throw new DaoDfmException("Can't save fish entry ", e);
        } finally {
            closePreparedStatement(statement);
            closeConnection(connection);
        }

    }


    @Override
    public Fish get(int id) throws DaoDfmException {

        /*

        SELECT f.fish_id, f.fish_name, f.description, ft.fish_type_name, la.area_name,
                pn.parameters_name, fs.min_range, fs.min_range, fs.nibble_level FROM fishes f
                INNER JOIN  fish_settings fs ON  f.fish_id = fs.fish_id RIGHT JOIN parameters_names as pn ON fs.param_name_id = pn.param_name_id
                RIGHT JOIN living_areas AS la on f.area_id = la.area_id
                RIGHT JOIN fish_types AS ft ON f.fish_type_id = ft.fish_type_id
        * */

//        String sql = "SELECT f.fish_id, f.fish_name, f.description, ft.fish_type_name, la.area_name, fn.id AS fish_nibble_id, fn.start_period, fn.end_period, fn.nibble_value" +
//                "fs.id AS fish_settings_id, fs.name_type, fs.min_value, fs.max_value, fs.nibble_level FROM fishes f " +
//                "INNER JOIN  fish_settings fs ON  f.id = fs.fish_id " +
//                "RIGHT JOIN living_areas AS la ON f.area_id = la.area_id " +
//                "RIGHT JOIN fish_types AS ft ON f.fish_type_id = ft.fish_type_id " +
//                "INNER JOIN fish_nibble fn ON f.id = fn.fish_id WHERE f.id = ?";

        String sql = "        SELECT f.fish_id, f.fish_name, f.description, ft.fish_type_name, la.area_name,\n" +
                "                pn.parameters_name, fs.min_range, fs.min_range, fs.nibble_level FROM fishes f\n" +
                "                INNER JOIN  fish_settings fs ON  f.fish_id = fs.fish_id RIGHT JOIN parameters_names AS pn ON fs.param_name_id = pn.param_name_id\n" +
                "                RIGHT JOIN living_areas AS la ON f.area_id = la.area_id\n" +
                "                RIGHT JOIN fish_types AS ft ON f.fish_type_id = ft.fish_type_id";

        Fish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            List<FishSetting> fishParams = new ArrayList<>();

            while (rs.next()) {

                fish = getFishFromRs(rs);
                fish.setFishParams(fishParams);

                fishParams.add(getNibbleStateParamFromRs(rs));

            }
            log.info(fish != null ? fish.toString() : "Fish by id not found");

        } catch (SQLException e) {
            log.error("some problem when you try get fish", e);
            throw new DaoDfmException("some problem when you try get fish", e);
        }

        return fish;
    }

    @Override
    public Fish update(Fish fish) {
        // TODO field type FK
        String sql = "UPDATE fish f INNER JOIN weather_state ws ON f.id = ws.fish_id "
                + "SET f.name = ?, f.description = ?, f.type = ?, ws.max = ?, ws.min = ?, ws.nibble = ?, ws.type_data_weather = ?";
        return null;
    }

    @Override
    public void delete(int id) throws DaoDfmException {
        List<Integer> typesFish = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;

        String sqlSelectTypes = "SELECT id FROM weather_state WHERE fish_id = ?";
        String sqlRemoveFishType = "DELETE FROM weather_state WHERE id = ?";
        String sqlRemoveFish = "DELETE FROM fishes WHERE id = ?";

        try {


            // get fish's types
            statement = connection.prepareStatement(sqlSelectTypes);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                typesFish.add(rs.getInt(1));
            }

            statement = connection.prepareStatement(sqlRemoveFishType);

            // create butch for remove types
            for (Integer typeId : typesFish) {
                statement.setInt(1, typeId);
                statement.addBatch();
            }

            int[] affectedRecords = statement.executeBatch();

            log.info("Remove Fish_Type rows: " + affectedRecords.length);

            // remove fish model
            statement = connection.prepareStatement(sqlRemoveFish);
            statement.setInt(1, id);
            statement.executeUpdate();

            connection.commit();

            log.info("Removed Fish with id: " + id);

        } catch (SQLException e) {
            rollback(connection);
            log.error("Fish remove error", e);
            throw new DaoDfmException("Fish remove error", e);
        } finally {
            closePreparedStatement(statement);
            closeConnection(connection);
        }
    }

    @Override
    public List<Fish> getAllWeather() throws DaoDfmException {
        String sql = "SELECT id fish_id, name, description FROM fishes";
        List<Fish> fishes = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                fishes.add(getFishFromRs(rs));
            }

            log.info(fishes.size() > 0 ? "Fish list: " + fishes.size() : "Fish result is zero");

        } catch (SQLException e) {
            throw new DaoDfmException("some problem when get List Weather", e);
        }

        return fishes;
    }

    public Fish getFishByTempForNibble(int temp, int fishId) throws DaoDfmException {

        String sql = "SELECT f.name, f.description, f.type ,ws.id type_data_id, ws.type_data_weather, ws.nibble, ws.min, ws.max, ws.fish_id "
                + "FROM fishes f INNER JOIN  year_periods ws ON f.id = ws.fish_id "
                + "WHERE ws.type_data_weather = 'nibbleDataType' AND ws.min <= ? AND ws.max >= ? AND (f.id = ?)";

        Fish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, temp);
            preparedStatement.setInt(2, temp);
            preparedStatement.setInt(3, fishId);

            ResultSet rs = preparedStatement.executeQuery();
            List<FishSetting> nibbleStateParams = new ArrayList<>();

            while (rs.next()) {
                fish = getFishFromRs(rs);
                fish.setFishParams(nibbleStateParams);

                nibbleStateParams.add(getNibbleStateParamFromRs(rs));
                fish.setFishParams(nibbleStateParams);
            }
            log.info(fish != null ? fish.toString() : "Fish by temp not found");

        } catch (SQLException e) {
            throw new DaoDfmException("can't get fish by Temp", e);
        }

        return fish;
    }

    private FishSetting getNibbleStateParamFromRs(ResultSet rs) throws SQLException {
        FishSetting nibbleStateParam = new FishSetting();
       /* nibbleStateParam.setId(rs.getInt("type_data_id"));
        nibbleStateParam.setStateDataType(ParamNames.valueOf(rs.getString("state_data_type")));
        nibbleStateParam.setMinValue(rs.getDouble("min_range"));
        nibbleStateParam.setMaxValue(rs.getDouble("max_range"));
        nibbleStateParam.setNibble(rs.getLong("result_nibble_value"));
*/

        return nibbleStateParam;
    }

    private Fish getFishFromRs(ResultSet rs) throws DaoDfmException {
        Fish fish = new Fish();
        try {

//            fish = FactoryProduser.createFish(rs.getString("type"));
            fish.setId(rs.getInt("fish_id"));
            fish.setDescription(rs.getString("description"));
            fish.setName(rs.getString("name"));
            fish.setFishType(FishTypes.valueOf("parameters_name"));

        } catch (SQLException e) {
            throw new DaoDfmException("Can't get fish from rs", e);
        }
        return fish;
    }

    private void setFishStatement(PreparedStatement statement, Fish fish) throws SQLException {
        statement.setString(1, fish.getName());
        statement.setString(2, fish.getDescription());
        statement.setString(3, fish.getFishType().name());

//        statement.setString(4, fish.getLivingArea().);

    }

    private void addParamsToBatch(FishSetting fishParameter, PreparedStatement statement) throws DaoDfmException {

        /*try {

            statement.setInt(1, fishParameter.getFishId());
            statement.setString(2, fishParameter.getStateDataType().name());
            statement.setDouble(3, fishParameter.getMinValue());
            statement.setDouble(4, fishParameter.getMaxValue());

            statement.addBatch();

        } catch (SQLException e) {
            log.error("Error when set fish params to state ", e);
            throw new DaoDfmException("Error when set fish params to state ", e);
        }*/


    }

    private void addNibbleToBatch(NibblePeriod fishNibble, PreparedStatement statement) throws DaoDfmException {

      /*  try {

            statement.setInt(1, fishNibble.getFishId());
            statement.setDate(2, new Date(fishNibble.getStart().getTime()));
            statement.setDate(3, new Date(fishNibble.getEnd().getTime()));
            statement.setDouble(4, fishNibble.getValue());


            statement.addBatch();

        } catch (SQLException e) {
            log.error("Error when set fish nibble to state ", e);
            throw new DaoDfmException("Error when set fish nibble to state", e);
        }
*/
    }
}
