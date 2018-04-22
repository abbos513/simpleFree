package com.freelance.dal.Config;

import com.freelance.dal.Security.CustomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    CustomProvider customProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .loginPage("/auth/LogIn")
                .successForwardUrl("/auth/Login")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/auth/SignUp", "/auth/LogIn", "/auth/hash/{hashCode}"/*, "/resources/**", "/Driver/Register", "/Advertiser/Register", "/api/**", "/Driver/Home", "/Advertiser/Home", "/fonts/**", "/icons/**", "/profileImages/**"*/)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/"/*, "/resources/**", "/Driver/Register", "/Advertiser/Register", "/api/**", "/Driver/Home", "/Advertiser/Home", "/fonts/**", "/icons/**", "/profileImages/**"*/);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customProvider);
    }

}
