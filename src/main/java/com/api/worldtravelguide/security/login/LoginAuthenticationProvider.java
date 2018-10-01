package com.api.worldtravelguide.security.login;

import com.api.worldtravelguide.domain.user.User;
import com.api.worldtravelguide.domain.user.UserRepository;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.security.AuthenticatedUserToken;
import com.api.worldtravelguide.security.SystemAuthenticationException;
import com.api.worldtravelguide.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    public LoginAuthenticationProvider(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        LoginAuthenticationToken loginAuthenticationToken = (LoginAuthenticationToken) authentication;
        User user = Optional.ofNullable(userRepository.findByEmailAndDeletedFalse(loginAuthenticationToken.getEmail()))
                .orElseThrow(() -> new SystemAuthenticationException(String.format("User not found. Email : %s", loginAuthenticationToken.getEmail()), ResponseCode.INVALID_CREDENTIALS));

        if (!passwordEncoder.matches(loginAuthenticationToken.getPassword(), user.getPassword())) {
            throw new SystemAuthenticationException(String.format("Password does not match. Email : %s", user.getEmail()), ResponseCode.INVALID_CREDENTIALS);
        }

        String userRole = Optional.ofNullable(user.getRole())
                .orElseThrow(() -> new SystemAuthenticationException(String.format("Not granted any authorities. Email : %s, Role : %s", user.getEmail(), user.getRole()), ResponseCode.AUTHORITIES_NOT_FOUND));

        return new AuthenticatedUserToken(jwtService.jwtTokenGenerator(user), user, AuthorityUtils.createAuthorityList(userRole));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(LoginAuthenticationToken.class);
    }
}
