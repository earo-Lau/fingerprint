package com.fingerprint.service.institution;

import com.fingerprint.model.EntityWrapper;
import com.fingerprint.model.Institution;
import com.fingerprint.service.Utils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.RecursiveTask;

/**
 * Created by lauearo on 25/05/2017.
 */
@Service
public class InstitutionHytrixService {
    @Autowired
    InstitutionService institutionService;
    @Autowired
    Utils utils;

    public ResponseEntity<Institution> serverError(long id){
        System.out.println("fallback call");
        return utils.createResponse(null, HttpStatus.BAD_GATEWAY);
    }

    //@HystrixCommand(fallbackMethod = "serverError")
    public ResponseEntity<Institution> get(long id){
        System.out.println("Normal call");
        return utils.createOkResponse(institutionService.get(id));
    }

    //@HystrixCommand(fallbackMethod = "serverError")
    public ResponseEntity<Institution> update(long id, Institution institution){
        return  utils.createOkResponse(institutionService.update(id, institution));
    }
}
