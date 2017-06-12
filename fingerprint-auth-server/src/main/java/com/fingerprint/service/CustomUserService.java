package com.fingerprint.service;

import com.fingerprint.dao.UserRepository;
import com.fingerprint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by lauearo on 07/06/2017.
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user.getUsername() == null){
            throw new UsernameNotFoundException("username not found");
        }

        return user;
    }

    public User create(User user){
        User exsiting = userRepository.findByUsername(user.getUsername());
        Assert.isNull(exsiting, "user: " + user.getUsername() +" already exists.");

        userRepository.save(user);
        return user;
    }
}
