package com.fingerprint.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by lauearo on 08/06/2017.
 */
public class User {
    private long id;

    @NotNull
    @Length(min = 4, max = 20)
    private String username;
    @NotNull
    @Length(min = 6, max = 20)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}