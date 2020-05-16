package com.university.javaeeproject.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserApprovalHandler userApprovalHandler;

    private static final String RESOURCE_ID = "resource_id";

    private static final String CLIEN_ID = "clientapp";
    private static final String CLIENT_SECRET = "my_password@123456";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String IMPLICIT = "implicit";
    private static final String SCOPE_READ = "read";
    private static final String SCOPE_WRITE = "write";
    private static final String TRUST = "trust";
    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;

/*        @Bean
        public JwtAccessTokenConverter accessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setSigningKey("as466gf");
            return converter;
        }*/


    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient(CLIEN_ID)
                .secret("{noop}" + CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD)
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
                 refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager);
/*
        endpoints
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter());*/
    }
}