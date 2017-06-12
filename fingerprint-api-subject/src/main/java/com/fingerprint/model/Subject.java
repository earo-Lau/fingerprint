package com.fingerprint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lauearo on 25/05/2017.
 */
@Entity
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String code;
    private String description;
}
