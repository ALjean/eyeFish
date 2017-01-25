package com.jean.config.security.jwt.endpoint;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jean.config.context.JwtSecurityConfig;

import com.jean.config.security.jwt.auth.jwt.extractor.TokenExtractor;
import com.jean.config.security.jwt.auth.jwt.verifier.TokenVerifier;
import com.jean.config.security.jwt.config.JwtSettings;
import com.jean.config.security.jwt.exceptions.InvalidJwtToken;
import com.jean.config.security.jwt.model.UserContext;
import com.jean.config.security.jwt.model.token.JwtToken;
import com.jean.config.security.jwt.model.token.JwtTokenFactory;
import com.jean.config.security.jwt.model.token.RawAccessJwtToken;
import com.jean.config.security.jwt.model.token.RefreshToken;

import com.jean.dao.entity.user.User;
import com.jean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jean on 02.01.17.
 */
@RestController
public class RefreshTokenEndpoint {

    private final JwtTokenFactory tokenFactory;
    private final JwtSettings jwtSettings;
    private final UserService userService;
    private final TokenVerifier tokenVerifier;
    private final TokenExtractor tokenExtractor;

    @Autowired
    public RefreshTokenEndpoint(TokenVerifier tokenVerifier, JwtSettings jwtSettings, UserService userService, JwtTokenFactory tokenFactory, @Qualifier("jwtHeaderTokenExtractor") TokenExtractor tokenExtractor) {
        this.tokenVerifier = tokenVerifier;
        this.jwtSettings = jwtSettings;
        this.userService = userService;
        this.tokenFactory = tokenFactory;
        this.tokenExtractor = tokenExtractor;
    }

    @RequestMapping(value = "/api/auth/token", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(JwtSecurityConfig.JWT_TOKEN_HEADER_PARAM));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        User user = userService.getUserByEmail(subject).orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));

        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}