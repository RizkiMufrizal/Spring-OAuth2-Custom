package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2AccessToken;
import com.rizki.mufrizal.spring.oauth2.custom.repository.OAuth2AccessTokenRepository;
import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2AccessTokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 9:04:46 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class OAuth2AccessTokenServiceImpl implements OAuth2AccessTokenService {

    @Autowired
    private OAuth2AccessTokenRepository oAuth2AccessTokenRepository;

    @Override
    public List<OAuth2AccessToken> findByClientId(String clientId) {
        return oAuth2AccessTokenRepository.findByClientId(clientId);
    }

}
