package com.fingerprint.service;

import com.fingerprint.model.EntityWrapper;
import com.fingerprint.model.ErrorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by lauearo on 02/06/2017.
 */
@Configuration
@Component
@EnableConfigurationProperties({ErrorProperties.class})
public class Utils {
    @Autowired
    private ErrorProperties errorProperties;

    public <T> EntityWrapper<T> createWrapper(T entity) {
        return new EntityWrapper<>(entity);
    }

    public <T> EntityWrapper<T> createWrapper(T entity, String code) {
        if (!StringUtils.isEmpty(code)) {
            String reason = errorProperties.getCode().get(code);
            return createWrapper(entity, code, reason);
        }

        return createWrapper(entity);
    }

    public <T> EntityWrapper<T> createWrapper(T entity, String code, String reason) {
        return new EntityWrapper<>(entity, code, reason);
    }

    public <T> ResponseEntity<T> createOkResponse(T body) {
        System.out.println("Response OK, body:" + body.toString());
        return createResponse(body, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus) {
        return new ResponseEntity<>(body, httpStatus);
    }

}
