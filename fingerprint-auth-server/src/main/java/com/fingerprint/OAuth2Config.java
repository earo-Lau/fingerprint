package com.fingerprint;

import com.fingerprint.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Created by lauearo on 07/06/2017.
 */
@Configuration
@EnableResourceServer
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("authenticationManagerBean")
    AuthenticationManager authenticationManager;
//    @Autowired
//    CustomUserService customUserService;
    private TokenStore token = new InMemoryTokenStore();


    @Value("${fingerprint.auth.server_pwd}")
    protected String SERVER_PWD;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(token)
                //.userDetailsService(customUserService)
                .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                    .withClient("browser")
                    .authorizedGrantTypes("refresh_token", "password")
                    .scopes("ui")
                    .accessTokenValiditySeconds(3600)
                    .refreshTokenValiditySeconds(2592000)
                .and()
                    .withClient("ui-edu")
                    .secret(SERVER_PWD)
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("server", "ui")
                    .accessTokenValiditySeconds(3600)
                    .refreshTokenValiditySeconds(2592000)
                .and()
                .withClient("institution").secret(SERVER_PWD).authorizedGrantTypes("client_credentials", "refresh_token").scopes("server").autoApprove(true)
                .and()
                .withClient("subject").secret(SERVER_PWD).authorizedGrantTypes("client_credentials", "refresh_token").scopes("server").autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }
}
