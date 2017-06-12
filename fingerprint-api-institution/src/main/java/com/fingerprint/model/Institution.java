package com.fingerprint.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lauearo on 25/05/2017.
 */
@Entity
public class Institution implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String introduce;
    private String logo;
    private String phone;
    private String address;
    private String email;

    public Institution() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
