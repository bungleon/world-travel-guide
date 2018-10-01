package com.api.worldtravelguide.security.jwt;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.security.AbstractSystemAuthenticationFilter;
import com.api.worldtravelguide.security.SystemAuthenticationException;
import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends AbstractSystemAuthenticationFilter {
    private final JwtService jwtService;


    public JwtAuthenticationFilter(Gson gson, JwtService jwtService) {
        super(gson);
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        try {
            String jwtToken = jwtService.jwtExtractor(request);
            JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(jwtToken);
            return super.getAuthenticationManager().authenticate(authenticationToken);

        } catch (org.springframework.security.core.AuthenticationException authException) {
            throw authException;
        } catch (Exception exception) {
        }

        throw new SystemAuthenticationException("System Error", ResponseCode.UNDEFINED_ERROR);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
