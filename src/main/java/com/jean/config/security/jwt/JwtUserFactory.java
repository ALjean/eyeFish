//package com.jean.config.security.jwt;
//
//
//import com.jean.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by jean on 10.04.16.
// */
//public class JwtUserFactory {
//
//
//
//    public static JwtUser create(User user) {
//        return new JwtUser(
//                (long)user.getId(),
//                user.getEmail(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getPassword(),
//                mapToGrantedAuthorities(user.getRole())
////                user.getEnabled(),
////                user.getLastPasswordResetDate()
//        );
//    }
//
//    private static List<GrantedAuthority> mapToGrantedAuthorities(String role) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(role));
//        return authorities;
//    }
//}
