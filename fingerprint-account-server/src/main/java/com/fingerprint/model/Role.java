package com.fingerprint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lauearo on 08/06/2017.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;

    private String name;
}
