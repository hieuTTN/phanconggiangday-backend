package com.web.config;

import com.web.jwt.JWTConfigurer;
import com.web.jwt.JwtTokenProvider;
import com.web.repository.UserRepository;
import com.web.utils.Contains;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider tokenProvider;

    private final UserRepository userRepository;

    private final CorsFilter corsFilter;

    public WebSecurityConfig(JwtTokenProvider tokenProvider, UserRepository userRepository, CorsFilter corsFilter) {
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.corsFilter = corsFilter;
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .and()
                .headers()
                .and()
                .authorizeRequests()

                .antMatchers("/api/*/admin/**").hasAnyAuthority(Contains.ROLE_ADMIN)
                .antMatchers("/api/*/teacher/**").hasAnyAuthority(Contains.ROLE_TEACHER, Contains.ROLE_HEAD_DEPARTMENT)
                .antMatchers("/api/*/assistant/**").hasAuthority(Contains.ROLE_ASSISTANT)
                .antMatchers("/api/*/head-department/**").hasAuthority(Contains.ROLE_HEAD_DEPARTMENT)
                .antMatchers("/api/*/specialist/**").hasAuthority(Contains.ROLE_SPECIALIST)
                .and()
                .apply(securityConfigurerAdapter());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }
    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider, userRepository);
    }

}

