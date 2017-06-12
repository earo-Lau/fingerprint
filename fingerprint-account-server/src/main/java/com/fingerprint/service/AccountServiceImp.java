package com.fingerprint.service;

import com.fingerprint.clients.AuthServiceClient;
import com.fingerprint.dao.AccountRepository;
import com.fingerprint.model.Account;
import com.fingerprint.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by lauearo on 08/06/2017.
 */
@Service
public class AccountServiceImp implements AccountService {
    private AccountRepository repository;
    private AuthServiceClient authService;

    public AccountServiceImp(AccountRepository repository, AuthServiceClient authService){
        this.repository = repository;
        this.authService = authService;
    }

    @Override
    public Account findByName(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Account create(User user) {
        Account existing = repository.findByUsername(user.getUsername());
        Assert.isNull(existing, "account: " + user.getUsername() + " has exists.");

        authService.create(user);
        Account newAccount = new Account();
        newAccount.setUsername(user.getUsername());

        repository.save(newAccount);
        return newAccount;
    }

    @Override
    public Account update(Account account) {
        Account existing = repository.findById(account.getId());
        Assert.isNull(existing, "account: " + account.getUsername() + " not found");

        existing.setInstitutionId(account.getInstitutionId());
        existing.setRoles(account.getRoles());
        existing.setSubjectId(account.getSubjectId());

        repository.save(existing);

        return existing;
    }


}
