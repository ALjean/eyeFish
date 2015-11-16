package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.AbstractFish;
import com.jean.entity.FactoryProduser;
import com.jean.entity.Spawning;
import com.jean.entity.NibbleStateParam;
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

        String sql = "INSERT INTO fish (name, description) VALUES (?, ?)";
        int result;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, fish.getName());
            preparedStatement.setString(2, fish.getDescription());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem with save fish");
        }


        if (result != 0) {
            log.info("Fish model save with name: " + fish.getName());
        }

    }

    @Override
    public AbstractFish read(int id) throws CustomDfmException {
        String sql = "SELECT f.name, f.description, ws.id type_data_id, ws.type_data_weather, ws.nibble, ws.min, ws.max, ws.fish_id, " +
                "s.id spawn_id, s.spawning, s.gluttony, s.sick " +
                "FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id " +
                "INNER JOIN spawning s ON f.id = s.fish_id WHERE f.id = ?";
        AbstractFish fish = null;


        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            List<NibbleStateParam> nibbleStateParams = new ArrayList<>();

            Spawning spawning = new Spawning();


            while (rs.next()) {
                fish = FactoryProduser.createFish(rs.getString("type"));
                fish.setId(rs.getInt("fish_id"));
                fish.setDescription(rs.getString("description"));
                fish.setName(rs.getString("name"));

                NibbleStateParam nibbleStateParam = new NibbleStateParam();
                nibbleStateParam.setId(rs.getInt("type_data_id"));
                nibbleStateParam.setMinValue(rs.getInt("min"));
                nibbleStateParam.setMaxValue(rs.getInt("max"));
                nibbleStateParam.setNibble(rs.getLong("nibble"));
                String key = rs.getString("type_data_weather");

                spawning.setId(rs.getInt("spawn_id"));
                spawning.setSpawning(rs.getDate("spawning"));
                spawning.setGluttony(rs.getDate("gluttony"));
                spawning.setSick(rs.getDate("sick"));

                if (key.equals(Constants.NIBBLE_DATA_TYPE)) {nibbleStateParams.add(nibbleStateParam);}


            }

//            fish.setSpawning(spawning);
                fish.setNibbleStateParams(nibbleStateParams);



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

    public AbstractFish getFishByTempForNibble(int temp, int fishId)  throws CustomDfmException{
        String sql =
                "SELECT f.name, f.description, ws.id type_data_id, ws.type_data_weather, ws.nibble, ws.min, ws.max, ws.fish_id, s.id spawn_id, s.spawning, s.gluttony, s.sickFROM " +
                        "FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id INNER JOIN spawning s ON f.id = s.fish_id WHERE ws.type_data_weather = 'nibbleDataType' " +
                        "and (ws.min >= ? and ws.max <= ? ) and(f.id = ?)";

        AbstractFish fish = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, temp);
            preparedStatement.setInt(2, temp);
            preparedStatement.setInt(3, fishId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                fish = FactoryProduser.createFish(rs.getString("type"));
                fish.setId(rs.getInt("fish_id")); //TODO


            }

        } catch (SQLException e){
            throw new CustomDfmException(e, "can't get fish by Temp");
        }

       return fish;
    }
}
