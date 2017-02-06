package com.rizki.mufrizal.spring.oauth2.custom.service;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2CountAccess;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 8:40:52 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface OAuth2CountAccessService {

    public OAuth2CountAccess findByClientId(String clientId);

    public void saveOAuth2CountAccess(OAuth2CountAccess oAuth2CountAccess);

    public void updateOAuth2CountAccess(OAuth2CountAccess oAuth2CountAccess);

}
