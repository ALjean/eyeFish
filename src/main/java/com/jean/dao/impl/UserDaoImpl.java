package com.jean.dao.impl;


import com.jean.DaoDfmException;
import com.jean.dao.UserDao;
import com.jean.entity.User;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by jean on 10.01.16.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private static final Logger log = Logger.getLogger(UserDaoImpl.class);

    @Override
    public Optional<User> getUserByEmail(String email) throws DaoDfmException {
        String sql = "SELECT * FROM users WHERE email = ?";
        User user = new User();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                user.setId(rs.getLong("id"));
//                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
/*                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setRole(rs.getString("role"));*/
            }

            log.info("get user by email: " + user.toString());

        } catch (SQLException e){
            log.error("Same problem when find user by email");
            throw new DaoDfmException("Same problem when find user by email", e);
        }

        return Optional.of(user) ;
    }
}
