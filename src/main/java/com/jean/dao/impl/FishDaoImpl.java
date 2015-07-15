package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by stas on 30.05.15.
 */

@Component
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

    private static final Logger log = LoggerFactory.getLogger(FishDaoImpl.class);



    @Override
    public void create(Fish fish) throws CustomDfmException {

        String sql = "INSERT INTO fish (name, description) VALUES (?, ?)";
        int result;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, fish.getName());
                preparedStatement.setString(2, fish.getDescription());
                result = preparedStatement.executeUpdate();
            }catch (SQLException e){
                throw  new CustomDfmException(e, "some problem with save fish");
            }


        if (result != 0) {
            log.info("Fish model save with name: " + fish.getName());
        }

    }

    @Override
    public Fish read(int id) {
        String sql = "SELECT * FROM Task WHERE id = ?";

        Fish fish = new Fish();

        return fish;
    }

    @Override
    public Fish update(Fish fish) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
