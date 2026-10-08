package com.spring_tutorial.board.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().and() // Enabling CSRF Protection
                .authorizeRequests()
                .antMatchers("/board/**", "/member/**").authenticated() // URL that requires authentication
                .and()
                .formLogin()
                .loginPage("/member/login_view.do")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
