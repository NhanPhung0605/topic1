package com.fpt.test.topic1.controller;

import com.fpt.test.topic1.dto.UserDTO;
import com.fpt.test.topic1.security.JwtTokenManager;
import com.fpt.test.topic1.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Admin
 * @created : 09-Aug-21
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO userDTO) {

        UserDetails userDetails = userService.loadUserByUsername(userDTO.getUsername());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenManager.generateToken(userDetails);
        userDTO.setToken(token);

        return userDTO;
    }

}
