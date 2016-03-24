package com.jean.config.security.handler;

import com.jean.CustomAuthenticationException;
import com.jean.CustomDfmException;
import com.jean.config.security.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

//    @Autowired
//    private AuthenticationSuccessHandler authenticationSuccessHandler;
//
//    @Autowired
//    private AuthenticationFailureHandler authenticationFailureHandler;
//
//    public TokenAuthenticationFilter() {
//        super("/fish/**");
//        setAuthenticationSuccessHandler(authenticationSuccessHandler);
//        setAuthenticationFailureHandler(authenticationFailureHandler);
//    }

    public TokenAuthenticationFilter() {
        super("/**");
//        setAuthenticationSuccessHandler((request, response, authentication) ->
//        {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            request.getRequestDispatcher(request.getServletPath() + request.getPathInfo()).forward(request, response);
//        });
//        setAuthenticationFailureHandler((request, response, authenticationException) ->
//                response.getOutputStream().print(authenticationException.getMessage()));
    }




    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String token = request.getHeader("token");
        if (token == null)
            token = request.getParameter("token");
        if (token == null) {
                throw new AuthenticationServiceException("No JWT token found in request headers");

//            TokenAuthentication authentication = new TokenAuthentication(null, null);
//            authentication.setAuthenticated(false);
//            return authentication;
        }
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        return getAuthenticationManager().authenticate(tokenAuthentication);
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }
}
