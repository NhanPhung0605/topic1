package com.fpt.test.topic1.service.impl;

import com.fpt.test.topic1.entity.UserEntity;
import com.fpt.test.topic1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author : Admin
 * @created : 09-Aug-21
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (ObjectUtils.isEmpty(userEntity)) {
            throw new UsernameNotFoundException("Username does not existed");
        }

        return userEntity;
    }
}
