//package com.jean.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.ConnectionRepository;
//import org.springframework.social.connect.UsersConnectionRepository;
//import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class UsersConnectionRepositoryProvider implements UsersConnectionRepository {
//
//    @Autowired
//    private JdbcUsersConnectionRepository jdbcUsersConnectionRepository;
//
//
//    @Override
//    public List<String> findUserIdsWithConnection(Connection<?> connection) {
//        return jdbcUsersConnectionRepository.findUserIdsWithConnection(connection);
//    }
//
//    @Override
//    public Set<String> findUserIdsConnectedTo(String providerId, Set<String> providerUserIds) {
//        return findUserIdsConnectedTo(providerId, providerUserIds);
//    }
//
//    @Override
//    public ConnectionRepository createConnectionRepository(String userId) {
//        return null;
//    }
//}
