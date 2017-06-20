package com.fingerprint.controllers;

import com.fingerprint.model.Account;
import com.fingerprint.model.User;
import com.fingerprint.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by lauearo on 08/06/2017.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Account get(@PathVariable("username") String username) {
        return accountService.findByName(username);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Account create(@Valid @RequestBody User user){
        return accountService.create(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Account update(@Valid @RequestBody Account account){
        return accountService.update(account);
    }
}
