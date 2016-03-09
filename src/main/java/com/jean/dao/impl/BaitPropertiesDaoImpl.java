package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.entity.BaitProperties;
import com.jean.enums.BrightLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BaitPropertiesDaoImpl extends BaseDaoImpl implements BaitPropertiesDao {

    private static Logger log = LoggerFactory.getLogger(BaitPropertiesDaoImpl.class);

    @Override
    public List<BaitProperties> getBaitColors(double cloudLevel) throws CustomDfmException {

        String sql = "SELECT bc.prop_name, bc.description  " + "FROM baits_colors AS bc " + "WHERE ? BETWEEN bc.cloud_min AND bc.cloud_max;";

        List<BaitProperties> baitsProperties = new ArrayList<>();

        log.info("Starting method getBaitColors(), with parameter values: [ cloudLevel: " + cloudLevel + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setDouble(1, cloudLevel);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baitsProperties.add(getBaitPropsFromRs(rs));
            }

            if (baitsProperties.isEmpty()) {
                throw new CustomDfmException("For some reason list of colors is empty");
            }

        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage());
        }

        log.info("End method getBaitColors(), list size is: " + baitsProperties.size());

        return baitsProperties;
    }

    @Override
    public List<BaitProperties> getBaitColors(BrightLevel brightLevel) throws CustomDfmException {

        String sql = "SELECT bc.prop_name, bc.description  " + "FROM baits_colors AS bc " + "WHERE prop_name LIKE ?";

        List<BaitProperties> baitsProperties = new ArrayList<>();

        log.info("Starting method getBaitColors(), with parameter values: [ colorName: " + brightLevel + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, brightLevel.name());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baitsProperties.add(getBaitPropsFromRs(rs));
            }

            if (baitsProperties.isEmpty()) {
                throw new CustomDfmException("For some reason list of colors is empty");
            }

        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage());
        }

        log.info("End method getBaitColors(), list size is: " + baitsProperties.size());

        return baitsProperties;
    }

    @Override
    public List<BaitProperties> getBaitTastes(double temperature) throws CustomDfmException {

        String sql = "SELECT bt.prop_name, bt.description " + "FROM baits_tastes AS bt " + "WHERE ? BETWEEN bt.temp_min AND bt.temp_max";

        List<BaitProperties> baitsProperties = new ArrayList<>();

        log.info("Starting method getBaitTastes(), with parameter values: [ temperature: " + temperature + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setDouble(1, temperature);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baitsProperties.add(getBaitPropsFromRs(rs));
            }

            if (baitsProperties.isEmpty()) {
                throw new CustomDfmException("For some reason list of tastes is empty");
            }

        } catch (SQLException e) {
            throw new CustomDfmException("Some problem with fetching list of tastes. " + "Message: " + e.getMessage());
        }

        log.info("End method getBaitTastes(), list size is: " + baitsProperties.size());

        return baitsProperties;

    }

    private BaitProperties getBaitPropsFromRs(ResultSet rs) throws SQLException {
        BaitProperties baitProp = new BaitProperties();
        baitProp.setName(rs.getString("prop_name"));
        baitProp.setDescription(rs.getString("description"));
        return baitProp;
    }


}
