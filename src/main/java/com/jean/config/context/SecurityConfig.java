/*
package com.jean.config.context;


import com.jean.config.security.JwtAuthenticationFilter;
import com.jean.config.security.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


*/
/**
 * Created by stas on 07.06.15.
 *//*


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        JwtAuthenticationFilter authenticationTokenFilter = new JwtAuthenticationFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {


        httpSecurity

                .csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()


                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/signup").permitAll()
                //TODO create valid patterns
                .antMatchers("*/
/**").permitAll()
                .anyRequest().authenticated();


        // Custom JWT based security filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

//        httpSecurity.headers().cacheControl();

    }


}*/
