package com.fingerprint.service;

import com.fingerprint.model.Account;
import com.fingerprint.model.User;

/**
 * Created by lauearo on 08/06/2017.
 */
public interface AccountService {
    Account findByName(String username);
    Account create(User user);
    Account update(Account account);
}
