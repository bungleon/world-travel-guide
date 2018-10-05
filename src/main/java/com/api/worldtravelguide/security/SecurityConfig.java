package com.api.worldtravelguide.security;

import com.api.worldtravelguide.security.jwt.JwtAuthenticationFilter;
import com.api.worldtravelguide.security.jwt.JwtAuthenticationProvider;
import com.api.worldtravelguide.security.jwt.JwtConfig;
import com.api.worldtravelguide.security.jwt.JwtService;
import com.api.worldtravelguide.security.login.LoginAuthenticationFilter;
import com.api.worldtravelguide.security.login.LoginAuthenticationProvider;
import com.google.gson.Gson;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.validation.ValidatorFactory;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String MATCH_ALL = "/api/**";
    public static final String AUTH_URL = "/auth/login";

    private final Gson gson;
    private final JwtConfig jwtConfig;
    private final ValidatorFactory validatorFactory;
    private final JwtService jwtService;
    private final SystemAuthenticationEntryPoint systemAuthenticationEntryPoint;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final LoginAuthenticationProvider loginAuthenticationProvider;

    public SecurityConfig(Gson gson, JwtConfig jwtConfig, ValidatorFactory validatorFactory, JwtService jwtService, SystemAuthenticationEntryPoint systemAuthenticationEntryPoint, JwtAuthenticationProvider jwtAuthenticationProvider, LoginAuthenticationProvider loginAuthenticationProvider) {
        this.gson = gson;
        this.jwtConfig = jwtConfig;
        this.validatorFactory = validatorFactory;
        this.jwtService = jwtService;
        this.systemAuthenticationEntryPoint = systemAuthenticationEntryPoint;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.loginAuthenticationProvider = loginAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/seed/**")
                .permitAll();
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .addFilterAfter(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtFilter(), LoginAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(systemAuthenticationEntryPoint);

        http.cors();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(loginAuthenticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
    public LoginAuthenticationFilter loginFilter() throws Exception {
        LoginAuthenticationFilter loginFilter = new LoginAuthenticationFilter(gson, validatorFactory, jwtConfig);
        loginFilter.setFilterProcessesUrl(AUTH_URL);
        loginFilter.setAllowSessionCreation(false);
        loginFilter.setAuthenticationManager(super.authenticationManager());
        return loginFilter;
    }

    public JwtAuthenticationFilter jwtFilter() throws Exception {
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(gson, jwtService);
        jwtFilter.setFilterProcessesUrl(MATCH_ALL);
        jwtFilter.setAllowSessionCreation(false);
        jwtFilter.setAuthenticationManager(super.authenticationManager());
        return jwtFilter;
    }
}
