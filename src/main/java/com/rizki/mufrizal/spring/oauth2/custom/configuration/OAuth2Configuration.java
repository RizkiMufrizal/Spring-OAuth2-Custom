package com.rizki.mufrizal.spring.oauth2.custom.configuration;

import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2AccessTokenService;
import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2CountAccessService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Jan 30, 2017
 * @Time 1:25:22 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.configuration
 *
 */
@Configuration
public class OAuth2Configuration {

    private static final String RESOURCE_ID = "customoauth2";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Autowired
        private OAuth2CountAccessService oAuth2CountAccessService;

        @Autowired
        private OAuth2AccessTokenService oAuth2AccessTokenService;

        @Override
        public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) throws Exception {
            TokenExtractorConfiguration tokenExtractorConfiguration = new TokenExtractorConfiguration(oAuth2CountAccessService, oAuth2AccessTokenService);
            resourceServerSecurityConfigurer
                    .resourceId(RESOURCE_ID)
                    .tokenExtractor(tokenExtractorConfiguration);
        }

        @Override
        public void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .authorizeRequests()
                    .antMatchers("/api/*").fullyAuthenticated()
                    .and()
                    .addFilterBefore(new CorsConfiguration(), ChannelProcessingFilter.class);
        }

    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Autowired
        private DataSource dataSource;

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            return new JwtAccessTokenConverter();
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {
            authorizationServerEndpointsConfigurer
                    .accessTokenConverter(jwtAccessTokenConverter())
                    .tokenStore(tokenStore())
                    .authenticationManager(this.authenticationManager);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
            clientDetailsServiceConfigurer
                    .jdbc(dataSource);
        }

        @Bean
        public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }

    }

}
