package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.entity.BaitProperties;
import com.jean.enums.BaitSettings;
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
    public List<BaitProperties> getBaitPropertiesByType(BaitSettings baitType) throws DaoDfmException {
        return null;
    }

    @Override
    public List<BaitProperties> getBaitColors(double cloudLevel) throws DaoDfmException {

        String sql = "SELECT bs.name, bs.description  " + "FROM baits_settings AS bs " + "WHERE ? BETWEEN bs.cloud_min AND bs.cloud_max AND bs.type = ?";

        List<BaitProperties> baitsProperties = new ArrayList<>();

        log.info("Starting method getBaitColors(), with parameter values: [ cloudLevel: " + cloudLevel + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setDouble(1, cloudLevel);
            preparedStatement.setString(2, BaitSettings.COLOR.name());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baitsProperties.add(getBaitPropsFromRs(rs));
            }

            if (baitsProperties.isEmpty()) {
                throw new DaoDfmException("For some reason list of colors is empty");
            }

        } catch (SQLException e) {
            throw new DaoDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage());
        }

        log.info("End method getBaitColors(), list size is: " + baitsProperties.size());

        return baitsProperties;
    }

    @Override
    public List<BaitProperties> getBaitColors(BrightLevel brightLevel) throws DaoDfmException {

        String sql = "SELECT bs.name, bs.description  " + "FROM baits_settings AS bs " + "WHERE bs.name LIKE ? AND bs.type = ?";

        List<BaitProperties> baitsProperties = new ArrayList<>();

        log.info("Starting method getBaitColors(), with parameter values: [ colorName: " + brightLevel + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, brightLevel.name());
            preparedStatement.setString(2, BaitSettings.COLOR.name());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baitsProperties.add(getBaitPropsFromRs(rs));
            }

            if (baitsProperties.isEmpty()) {
                throw new DaoDfmException("For some reason list of colors is empty");
            }

        } catch (SQLException e) {
            throw new DaoDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage(), e);
        }

        log.info("End method getBaitColors(), list size is: " + baitsProperties.size());

        return baitsProperties;
    }

    @Override
    public List<BaitProperties> getBaitTastes(double temperature) throws DaoDfmException {

        String sql = "SELECT bs.name, bs.description " + "FROM baits_settings AS bs " + "WHERE ? BETWEEN bs.temp_min AND bs.temp_max AND bs.type = ?";

        List<BaitProperties> baitsProperties = new ArrayList<>();

        log.info("Starting method getBaitTastes(), with parameter values: [ temperature: " + temperature + " ]");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setDouble(1, temperature);
            preparedStatement.setString(2, BaitSettings.TASTE.name());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                baitsProperties.add(getBaitPropsFromRs(rs));
            }

            if (baitsProperties.isEmpty()) {
                throw new DaoDfmException("For some reason list of tastes is empty");
            }

        } catch (SQLException e) {
            throw new DaoDfmException("Some problem with fetching list of tastes. " + "Message: " + e.getMessage(), e);
        }

        log.info("End method getBaitTastes(), list size is: " + baitsProperties.size());

        return baitsProperties;

    }

    private BaitProperties getBaitPropsFromRs(ResultSet rs) throws SQLException {
        BaitProperties baitProp = new BaitProperties();
        baitProp.setId(rs.getInt("id"));
        baitProp.setName(rs.getString("name"));
        baitProp.setDescription(rs.getString("description"));
        return baitProp;
    }


}
