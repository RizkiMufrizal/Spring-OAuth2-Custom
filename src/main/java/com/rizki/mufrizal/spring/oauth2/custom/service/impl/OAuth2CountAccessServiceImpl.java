package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2CountAccess;
import com.rizki.mufrizal.spring.oauth2.custom.repository.OAuth2CountAccessRepository;
import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2CountAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 8:44:35 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class OAuth2CountAccessServiceImpl implements OAuth2CountAccessService {

    @Autowired
    private OAuth2CountAccessRepository oAuth2CountAccessRepository;

    @Override
    public OAuth2CountAccess findByClientId(String clientId) {
        return oAuth2CountAccessRepository.findByClientId(clientId);
    }

    @Transactional
    @Override
    public void saveOAuth2CountAccess(OAuth2CountAccess oAuth2CountAccess) {
        oAuth2CountAccessRepository.save(oAuth2CountAccess);
    }

    @Transactional
    @Override
    public void updateOAuth2CountAccess(OAuth2CountAccess oAuth2CountAccess) {
        oAuth2CountAccessRepository.save(oAuth2CountAccess);
    }

}
