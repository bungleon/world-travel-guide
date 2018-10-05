package com.api.worldtravelguide.controller;

import com.api.worldtravelguide.domain.user.User;
import com.api.worldtravelguide.domain.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seed")
public class Seed {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    public Seed(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create-user")
    public String createUser() {
        User user = new User();
        user.setEmail("erman@bumin.io");
        user.setPassword(passwordEncoder.encode("72745275"));
        user.setRole("ADMIN");
        user.setFirstName("Erman");
        user.setLastName("ÖZ");
        user.setEnabled(true);
        userRepository.save(user);
        return "OK";
    }
}
