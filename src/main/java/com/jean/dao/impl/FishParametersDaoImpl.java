package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.entity.FishParameter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jean on 12.03.16.
 */

@Repository
public class FishParametersDaoImpl extends BaseDaoImpl {

    public void save(FishParameter fishParameter) throws CustomDfmException {
        String sql = "INSERT INTO fish_settings (fish_id, name_type, min_value, max_value, nibble_level) VALUES (?, ?, ?, ?, ?)";



        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, fishParameter.getFishId());
            preparedStatement.setString(2, fishParameter.getStateDataType().name());
            preparedStatement.setDouble(3, fishParameter.getMinValue());
            preparedStatement.setDouble(4, fishParameter.getMaxValue());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw new CustomDfmException("Error when saved fish params ", e);
        }
    }


}
