package com.fingerprint.controller;

import com.fingerprint.dao.UserRepository;
import com.fingerprint.model.User;
import com.fingerprint.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lauearo on 07/06/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    CustomUserService userService;

    @RequestMapping("/current")
    public Principal getUser(Principal principal){
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
