package com.fingerprint.service;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedAuthoritiesExtractor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import java.util.*;

/**
 * Created by lauearo on 08/06/2017.
 */
public class CustomUserInfoTokenService implements ResourceServerTokenServices {
    private static final String[] PRINCIPAL_KEYS = new String[] { "user", "username",
            "userid", "user_id", "login", "id", "name" };

    private final String userInfoEndpointUrl;
    private final String clientId;

    private OAuth2RestOperations restTemplate;
    private String tokenType = DefaultOAuth2AccessToken.BEARER_TYPE;
    private AuthoritiesExtractor authoritiesExtractor = new FixedAuthoritiesExtractor();

    public CustomUserInfoTokenService(String userInfoEndpointUrl, String clientId) {
        this.userInfoEndpointUrl = userInfoEndpointUrl;
        this.clientId = clientId;
    }

    public void setTokenType(String tokenType){
        this.tokenType = tokenType;
    }

    public void setRestTemplate(OAuth2RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setAuthoritiesExtractor(AuthoritiesExtractor authoritiesExtractor) {
        this.authoritiesExtractor = authoritiesExtractor;
    }

    /****** ResourceServerTokenServices Begin ******/

    @Override
    public OAuth2Authentication loadAuthentication(String s) throws AuthenticationException, InvalidTokenException {
        Map<String, Object> map = getMap(this.userInfoEndpointUrl, s);
        if(map.containsKey("error")){
            throw new InvalidTokenException(s);
        }

        return extractAuthentication(map);
    }

    private OAuth2Authentication extractAuthentication(Map<String, Object> map) {
        Object principal = getPrincipal(map);
        OAuth2Request request = getRequest(map);
        List<GrantedAuthority> authorities = this.authoritiesExtractor.extractAuthorities(map);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, "N/A", authorities);
        token.setDetails(map);

        return new OAuth2Authentication(request, token);
    }

    @SuppressWarnings("unchecked")
    private OAuth2Request getRequest(Map<String, Object> map) {
        Map<String, Object> request = (Map<String, Object>) map.get("oauth2Request");
        String clientId = request.get("clientId").toString();
        Set<String> scope = new LinkedHashSet<>(
                request.containsKey("scope") ? (Collection<String>) request.get("scope") : Collections.emptySet()
        );

        return new OAuth2Request(
                null,
                clientId,
                null,
                true,
                new HashSet<>(scope),
                null,
                null,
                null,
                null);
    }

    private Object getPrincipal(Map<String, Object> map){
        for (String key :
                PRINCIPAL_KEYS) {
            if(map.containsKey(key)){
                return map.get(key);
            }
        }

        return "unknown";
    }

    @Override
    public OAuth2AccessToken readAccessToken(String s) {
        return null;
    }
    /****** ResourceServerTokenServices End ******/

    @SuppressWarnings("unchecked")
    private Map<String, Object> getMap(String path, String accessToken){
        try{
            OAuth2RestOperations restTemplate = this.restTemplate;
            if(restTemplate == null){
                BaseOAuth2ProtectedResourceDetails resouce = new BaseOAuth2ProtectedResourceDetails();
                resouce.setClientId(this.clientId);
                restTemplate = new OAuth2RestTemplate(resouce);
            }

            OAuth2AccessToken existingToken = restTemplate.getOAuth2ClientContext().getAccessToken();
            if(existingToken == null || !accessToken.equals(existingToken.getValue())){
                DefaultOAuth2AccessToken newToken = new DefaultOAuth2AccessToken(accessToken);
                newToken.setTokenType(this.tokenType);
                restTemplate.getOAuth2ClientContext().setAccessToken(newToken);
            }

            return restTemplate.getForEntity(path, Map.class).getBody();
        }catch (Exception ex){
            return Collections.singletonMap("error", "Could not fetch user details");
        }
    }

}
