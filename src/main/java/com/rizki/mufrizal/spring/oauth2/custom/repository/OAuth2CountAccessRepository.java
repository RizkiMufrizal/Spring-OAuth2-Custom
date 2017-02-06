package com.rizki.mufrizal.spring.oauth2.custom.repository;

import com.rizki.mufrizal.spring.oauth2.custom.domain.OAuth2CountAccess;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 8:40:20 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.repository
 *
 */
public interface OAuth2CountAccessRepository extends PagingAndSortingRepository<OAuth2CountAccess, String> {

    OAuth2CountAccess findByClientId(String clientId);

}
