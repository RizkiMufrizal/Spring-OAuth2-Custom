package com.rizki.mufrizal.spring.oauth2.custom.service;

import java.util.Set;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Apr 18, 2017
 * @Time 10:47:03 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface OAuth2AccessTokenRedis {

    public Set<byte[]> getKeyRedis(String key);
}
