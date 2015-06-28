package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
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




    @Override
    public void create(Fish fish) throws CustomDfmException {

        String sql = "INSERT INTO fish (name, description, temp_min, temp_max, pressure_min, pressure_max) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection connection = getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, fish.getName());
                preparedStatement.setString(2, fish.getDescription());
                preparedStatement.setFloat(3, fish.getTempMin());
                preparedStatement.setFloat(4, fish.getTempMax());
                preparedStatement.setInt(5, fish.getPressureMin());
                preparedStatement.setInt(6, fish.getPressureMax());

                int result = preparedStatement.executeUpdate();
            }catch (SQLException e){
                throw  new CustomDfmException(e, "some problem with save fish");
            }



        int result = 1;

        if (result != 0) {
            System.out.println("save fish" + fish.getName());
        } else {
            System.out.println("failed save" + fish.getName());
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
