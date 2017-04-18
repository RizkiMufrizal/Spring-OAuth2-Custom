package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.service.OAuth2AccessTokenRedis;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Apr 18, 2017
 * @Time 10:47:10 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
public class OAuth2AccessTokenRedisImpl implements OAuth2AccessTokenRedis {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Set<byte[]> getKeyRedis(String key) {
        return redisTemplate.getConnectionFactory().getConnection().keys(key.getBytes());
    }

}
