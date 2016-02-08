package com.jean.config;

import com.jean.config.security.handler.CustomAuthenticationSuccessHandler;
import com.jean.config.security.RepositoryUserDetailsService;
import com.jean.config.security.SimpleSocialUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by stas on 07.06.15.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
//                .antMatchers("/fish/**").authenticated() //TODO patterns
                .and()
                .formLogin().usernameParameter("email").passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout().and()
                .apply(new SpringSocialConfigurer());


//        http
//                //Configures form login
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login/authenticate")
//                .failureUrl("/login?error=bad_credentials")
//                //Configures the logout function
//                .and()
//                .logout()
//                .deleteCookies("JSESSIONID")
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                //Configures url based authorization
//                .and()
//                .authorizeRequests()
//                //Anyone can access the urls
//                .antMatchers(
//                        "/auth/**",
//                        "/login",
//                        "/signup/**",
//                        "/register/**"
//                ).permitAll()
//                //The rest of the our application is protected.
//                .antMatchers("/**").hasRole("USER")
//                //Adds the SocialAuthenticationFilter to Spring Security's filter chain.
//                .and()
//                .apply(new SpringSocialConfigurer());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SocialUserDetailsService socialUserDetailsService() {
        return new SimpleSocialUserDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new RepositoryUserDetailsService();
    }


    @Bean
    public CustomAuthenticationSuccessHandler customSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler customFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }

}
