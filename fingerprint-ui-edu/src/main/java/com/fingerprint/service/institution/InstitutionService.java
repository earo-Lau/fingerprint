package com.fingerprint.service.institution;

import com.fingerprint.model.Institution;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lauearo on 25/05/2017.
 */
@FeignClient("institution")
public interface InstitutionService {

    @RequestMapping(method = RequestMethod.GET, value = "/api/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Institution get(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Institution update(@PathVariable("id") long id, Institution institution);
}
