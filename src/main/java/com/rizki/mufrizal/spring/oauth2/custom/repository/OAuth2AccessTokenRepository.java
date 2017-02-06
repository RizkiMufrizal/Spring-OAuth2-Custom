package com.rizki.mufrizal.spring.oauth2.custom.repository;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2AccessToken;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 9:03:18 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.repository
 *
 */
public interface OAuth2AccessTokenRepository extends PagingAndSortingRepository<OAuth2AccessToken, String> {

    OAuth2AccessToken findByClientId(String clientId);

}
