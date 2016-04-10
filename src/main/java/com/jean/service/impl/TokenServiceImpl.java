//package com.jean.service.impl;
//
//import com.jean.CustomDfmException;
//import com.jean.entity.User;
//import com.jean.service.TokenService;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class TokenServiceImpl implements TokenService {
//
//
//    @Autowired
//    private UserServiceImpl userDetailsService;
//
//    @Override
//    public String getToken(String username, String password) throws CustomDfmException {
//        if (username == null || password == null)
//            return null;
//        User user = userDetailsService.getUserByEmail(username);
//        Map<String, Object> tokenData = new HashMap<>();
//        if (password.equals(user.getPassword())) {
//            tokenData.put("client_role", user.getRole());
//            tokenData.put("user_id", user.getId());
//            tokenData.put("username", user.getFirstName() + " " + user.getLastName());
//            tokenData.put("token_create_date", new Date().getTime());
//            Calendar calendar = Calendar.getInstance();
//            calendar.add(Calendar.YEAR, 100);
//            tokenData.put("token_expiration_date", calendar.getTime());
//            JwtBuilder jwtBuilder = Jwts.builder();
//            jwtBuilder.setExpiration(calendar.getTime());
//            jwtBuilder.setClaims(tokenData);
//            String key = "abc123";
//            return jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
//        } else {
//            throw new CustomDfmException("Authentication error");
//        }
//    }
//}
