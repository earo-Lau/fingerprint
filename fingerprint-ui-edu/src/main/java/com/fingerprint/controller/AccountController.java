package com.fingerprint.controller;

import com.fingerprint.model.Account;
import com.fingerprint.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lauearo on 08/06/2017.
 */
@RestController
@RequestMapping("/profile")
public class AccountController {
    @Autowired
    ProfileService profileService;

    @RequestMapping("/current")
    public Account get(Principal principal){
        return profileService.get(principal.getName());
    }
}
