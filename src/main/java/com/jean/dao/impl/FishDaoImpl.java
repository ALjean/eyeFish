package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.*;
import com.jean.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by stas on 30.05.15.
 */

@Repository
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

    private static final Logger log = LoggerFactory.getLogger(FishDaoImpl.class);


    @Override
    public void save(AbstractFish fish) throws CustomDfmException {

        String sql = "INSERT INTO fish (name, description, type) VALUES (?, ?, ?)";
        int result;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, fish.getName());
            preparedStatement.setString(2, fish.getDescription());

            if(fish instanceof CalmFish){
                preparedStatement.setString(3, Constants.FISH_TYPE_CALM);
            }
            if(fish instanceof PredatorFish){
                preparedStatement.setString(3, Constants.FISH_TYPE_PREDATOR);
            }

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem with save fish");
        }

            log.info(result != 0 ? "Fish model save with name: " + fish.getClass() : "Didn't save" + fish.getClass());

    }

    @Override
    public AbstractFish read(int id) throws CustomDfmException {

        String sql = "SELECT f.name, f.description, f.type, ws.id type_data_id, ws.type_data_weather, ws.nibble, ws.min, ws.max, ws.fish_id, " +
                "s.id spawn_id, s.spawning, s.gluttony, s.sick " +
                "FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id " +
                "INNER JOIN spawning s ON f.id = s.fish_id WHERE f.id = ?";

        AbstractFish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            List<NibbleStateParam> nibbleStateParams = new ArrayList<>();

            while (rs.next()) {
                String key = rs.getString("type_data_weather");

                fish = getFishFromRs(rs);
                fish.setNibbleStateParams(nibbleStateParams);

                if (key.equals(Constants.NIBBLE_DATA_TYPE)) {
                    nibbleStateParams.add(getNibbleStateParamFromRs(rs));
                }

            }
            log.info(fish != null ? fish.toString() : "Fish by id not found");

        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem when you try read fish");
        }

        return fish;
    }

    @Override
    public AbstractFish update(AbstractFish fish) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
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

    public AbstractFish getFishByTempForNibble(int temp, int fishId)  throws CustomDfmException{

        String sql =
                "SELECT f.name, f.description, f.type ,ws.id type_data_id, ws.type_data_weather, ws.nibble, ws.min, ws.max, ws.fish_id, s.id spawn_id, s.spawning, s.gluttony, s.sick " +
                        "FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id INNER JOIN spawning s ON f.id = s.fish_id " +
                        "WHERE ws.type_data_weather = 'nibbleDataType' " +
                        "and ws.min <= ? and ws.max >= ? and (f.id = ?)";

        AbstractFish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, temp);
            preparedStatement.setInt(2, temp);
            preparedStatement.setInt(3, fishId);

            ResultSet rs = preparedStatement.executeQuery();
            List<NibbleStateParam> nibbleStateParams = new ArrayList<>();

            while (rs.next()){
                fish = getFishFromRs(rs);
                fish.setNibbleStateParams(nibbleStateParams);

                nibbleStateParams.add(getNibbleStateParamFromRs(rs));
                fish.setNibbleStateParams(nibbleStateParams);
            }
            log.info(fish != null ? fish.toString() : "Fish by temp not found");

        } catch (SQLException e){
            throw new CustomDfmException(e, "can't get fish by Temp");
        }

       return fish;
    }

    private NibbleStateParam getNibbleStateParamFromRs(ResultSet rs) throws SQLException {
        NibbleStateParam nibbleStateParam = new NibbleStateParam();
        nibbleStateParam.setId(rs.getInt("type_data_id"));
        nibbleStateParam.setMinValue(rs.getInt("min"));
        nibbleStateParam.setMaxValue(rs.getInt("max"));
        nibbleStateParam.setNibble(rs.getLong("nibble"));
        return nibbleStateParam;
    }

    private AbstractFish getFishFromRs(ResultSet rs) throws SQLException, CustomDfmException {
        AbstractFish fish = FactoryProduser.createFish(rs.getString("type"));
        fish.setId(rs.getInt("fish_id"));
        fish.setDescription(rs.getString("description"));
        fish.setName(rs.getString("name"));
        return fish;
    }
}
