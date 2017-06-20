package com.fingerprint.service.profile;

import com.fingerprint.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by lauearo on 19/06/2017.
 */
@FeignClient("account-server")
public interface ProfileService {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{username}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Account get(@PathVariable("username") String username);
}
