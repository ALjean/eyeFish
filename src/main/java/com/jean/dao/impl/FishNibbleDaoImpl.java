package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.dao.FishNibbleDao;
import com.jean.entity.NibblePeriod;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jean on 12.03.16.
 */
@Repository
public class FishNibbleDaoImpl extends BaseDaoImpl implements FishNibbleDao {

//    public void save(FishNibble fishNibble) throws CustomDfmException {
//
//        String sql = "INSERT INTO fish_nibble (fish_id, start_period, end_period, nibble_value) VALUES (?, ?, ?, ?)";
//
//
//        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, fishNibble.getFishId());
//            preparedStatement.setDate(2, new Date(fishNibble.getStart().getTime()));
//            preparedStatement.setDate(3, new Date(fishNibble.getEnd().getTime()));
//            preparedStatement.setDouble(4, fishNibble.getValue());
//
//            preparedStatement.executeUpdate();
//
//
//        } catch (SQLException e) {
//            throw new CustomDfmException("Error saved nibble", e);
//        }
//
//
//    }

//    public void save(FishNibble fishNibble, boolean isCommitOff) throws SQLException, CustomDfmException {
//        getConnection().setAutoCommit(isCommitOff);
//        save(fishNibble);
//
//    }

    public List<NibblePeriod> getAllFishNibbleByFishId(int fishId) throws DaoDfmException {
        String sql = "SELECT * FROM fish_nibble WHERE fish_id = ? ";
	return null;

      /*  try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, fishId);

            ResultSet rs = preparedStatement.executeQuery();

            List<NibblePeriod> nibbles = new ArrayList<>();
            while (rs.next()) {
                NibblePeriod nibble = new NibblePeriod();
                nibble.setId(rs.getInt("id"));
                nibble.setValue(rs.getDouble("nibble_value"));
                nibble.setStart(rs.getDate("start_period"));
                nibble.setEnd(rs.getDate("end_period"));
                nibbles.add(nibble);
            }

            return nibbles;

        } catch (SQLException e) {
            throw new DaoDfmException("Error when get nibble", e);
        }*/

    }
}
