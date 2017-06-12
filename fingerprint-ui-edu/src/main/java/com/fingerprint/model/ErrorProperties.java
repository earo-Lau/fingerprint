package com.fingerprint.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lauearo on 02/06/2017.
 */
@Component
@ConfigurationProperties(prefix = "fingerprint.error")
@PropertySource("classpath:customError.properties")
public class ErrorProperties implements Serializable {
    private Map<String, String> code = new HashMap<>();

    public Map<String, String> getCode() {
        return code;
    }

    public void setCode(Map<String, String> code) {
        this.code = code;
    }
}
