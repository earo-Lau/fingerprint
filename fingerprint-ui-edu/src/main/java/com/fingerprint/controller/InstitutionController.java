package com.fingerprint.controller;

import com.fingerprint.model.EntityWrapper;
import com.fingerprint.model.ErrorProperties;
import com.fingerprint.model.Institution;
import com.fingerprint.service.institution.InstitutionHytrixService;
import com.fingerprint.service.institution.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lauearo on 25/05/2017.
 */
@RestController
@RequestMapping("/ins")
public class InstitutionController {
    @Autowired
    InstitutionHytrixService institutionHytrixService;
    @Autowired
    InstitutionService institutionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Institution get(@PathVariable("id") long id){
        return institutionService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json" })
    public Institution update(@PathVariable("id") long id, @RequestBody Institution institution){
        return institutionService.update(id, institution);
    }
}
