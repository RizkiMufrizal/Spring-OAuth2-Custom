package com.rizki.mufrizal.spring.oauth2.custom.configuration;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2CountAccess;
import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2AccessTokenService;
import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2CountAccessService;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Jan 31, 2017
 * @Time 10:07:07 AM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.configuration
 *
 */
public class TokenExtractorConfiguration implements TokenExtractor {

    private final OAuth2CountAccessService oAuth2CountAccessService;
    private final OAuth2AccessTokenService oAuth2AccessTokenService;

    public TokenExtractorConfiguration(OAuth2CountAccessService oAuth2CountAccessService, OAuth2AccessTokenService oAuth2AccessTokenService) {
        this.oAuth2CountAccessService = oAuth2CountAccessService;
        this.oAuth2AccessTokenService = oAuth2AccessTokenService;
    }

    @Override
    public Authentication extract(HttpServletRequest request) {
        String tokenValue = extractHeaderToken(request);
        if (tokenValue != null) {
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(tokenValue, "");
            return authentication;
        }
        return null;
    }

    /**
     * Extract the OAuth bearer token from a header.
     *
     * @param request The request.
     * @return The token, or null if no OAuth authorization header was supplied.
     */
    protected String extractHeaderToken(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders("Authorization");
        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
                String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();

                if (authHeaderValue.split(":")[0] == null) {
                    return null;
                }

                String clientId = authHeaderValue.split(":")[0];

                List<com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2AccessToken> oAuth2AccessToken = oAuth2AccessTokenService.findByClientId(clientId);

                if (oAuth2AccessToken.isEmpty()) {
                    return null;
                }

                OAuth2CountAccess oAuth2CountAccess = oAuth2CountAccessService.findByClientId(clientId);

                if (oAuth2CountAccess == null) {
                    OAuth2CountAccess countAccess = new OAuth2CountAccess();
                    countAccess.setClientId(clientId);
                    countAccess.setCountAccess(1);
                    oAuth2CountAccessService.saveOAuth2CountAccess(countAccess);
                } else {
                    oAuth2CountAccess.setCountAccess(oAuth2CountAccess.getCountAccess() + 1);
                    oAuth2CountAccessService.updateOAuth2CountAccess(oAuth2CountAccess);
                }

                request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE,
                        value.substring(0, OAuth2AccessToken.BEARER_TYPE.length()).trim());
                int commaIndex = authHeaderValue.split(":")[1].indexOf(',');
                if (commaIndex > 0) {
                    authHeaderValue.split(":")[1] = authHeaderValue.split(":")[1].substring(0, commaIndex);
                }
                return authHeaderValue.split(":")[1];
            }
        }

        return null;
    }
}
