package com.jean.config.security;

import com.jean.entity.User;
import com.jean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class RepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }


        return ExampleUserDetails.getBuilder()
                .firstName(user.getFirstName())
                .id((long) user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .username(user.getEmail())
                .build();
    }
}
