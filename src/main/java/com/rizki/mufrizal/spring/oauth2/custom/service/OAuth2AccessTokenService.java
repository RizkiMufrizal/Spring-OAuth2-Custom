package com.rizki.mufrizal.spring.oauth2.custom.service;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2AccessToken;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 9:04:16 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface OAuth2AccessTokenService {

    public OAuth2AccessToken findByClientId(String clientId);

}
