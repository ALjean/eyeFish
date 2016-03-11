package com.jean.dao.impl;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.jean.enums.BaitType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jean.CustomDfmException;
import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.BaitProperties;
import org.springframework.stereotype.Repository;

@Repository
public class BaitDaoImpl extends BaseDaoImpl implements BaitDao {

    private static Logger log = LoggerFactory.getLogger(BaitDaoImpl.class);

    @Override
    public List<Bait> getBaitsForFishByDate(Date date, int fishId) throws CustomDfmException {

        String sql = "SELECT b.id, b.name, b.bait_type, b.description, bf.is_priority "
                + "FROM baits AS b INNER JOIN bindings_baits_to_fishes AS bf ON bf.bait_id = b.id "
                + "INNER JOIN bindings_baits_to_seasons AS bs ON bs.bait_id = b.id WHERE bf.fish_id = ? " + "AND "
                + "? BETWEEN bs.start_period AND bs.end_period ";

        List<Bait> baits = new ArrayList<>();

        log.info("Starting method getBaitsForFishByDate(), with parameter values: [ fishId: " + fishId + ", date: " + date + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, fishId);
            preparedStatement.setDate(2, date);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baits.add(getBaitFromRs(rs));
            }

            if (baits.isEmpty()) {
                throw new CustomDfmException("For some reason list of baits is empty");
            }

        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage());
        }

        log.info("End method getBaitColors(), list size is: " + baits.size());

        return baits;
    }




    @Override
    public String getMessage(String key) throws CustomDfmException {

        String sql = "SELECT mess_text FROM messages WHERE string_key LIKE ?";

        String result = "";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, key);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result = rs.getString("mess_text");
            }
        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with fetching message text. " + "Message: " + e.getMessage());
        }
        return result;
    }

    @Override
    public Integer save(Bait bait) throws CustomDfmException {
        String sql = "INSERT INTO baits (name, description, type) VALUES (?, ?, ?)";


        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, bait.getName());
            preparedStatement.setString(2, bait.getDescription());
            preparedStatement.setString(3, bait.getType().name());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            int savedId = 0;
            if (rs.next()){
                savedId=rs.getInt(1);
            }
            log.info("Created Bait with id:" + savedId);

             return savedId;

        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with save message text. " + "Message: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws CustomDfmException {

    }

    public List<Bait> getBaitListToFish(int id) throws CustomDfmException {

        String sql = "SELECT * from baits WHERE id IN (SELECT fish_id from baits_to_fishes WHERE fish_id = ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            List<Bait> list = new ArrayList<>();

            while (rs.next()) {
                list.add(getBaitFromRs(rs));
            }

            return list;

        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with save message text. " + "Message: " + e.getMessage());
        }

    }

    private Bait getBaitFromRs(ResultSet rs) throws SQLException {
        Bait bait = new Bait();
        bait.setId(rs.getInt("id"));
        bait.setType(BaitType.valueOf(rs.getString("type")));
        bait.setName(rs.getString("name"));
        bait.setDescription(rs.getString("description"));
        return bait;
    }


}
