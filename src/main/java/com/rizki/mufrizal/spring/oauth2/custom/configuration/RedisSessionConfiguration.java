package com.rizki.mufrizal.spring.oauth2.custom.configuration;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Apr 16, 2017
 * @Time 11:04:20 AM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.configuration
 *
 */
@Configuration
@PropertySource("classpath:application.yml")
@EnableRedisHttpSession
public class RedisSessionConfiguration {

    @Autowired
    private Environment environment;

    private JedisPoolConfig jedisPoolConfig() {
        final JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(environment.getRequiredProperty("spring.redis.max-total")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(environment.getRequiredProperty("spring.redis.max-idle")));
        jedisPoolConfig.setMinIdle(Integer.parseInt(environment.getRequiredProperty("spring.redis.min-idle")));
        jedisPoolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(Integer.parseInt(environment.getRequiredProperty("spring.redis.min-evictable-idle-time-millis"))).toMillis());
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(Integer.parseInt(environment.getRequiredProperty("spring.redis.time-between-eviction-runs-millis"))).toMillis());
        jedisPoolConfig.setBlockWhenExhausted(Boolean.valueOf(environment.getRequiredProperty("spring.redis.block-when-exhausted")));
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig());
        jedisConnectionFactory.setPort(Integer.parseInt(environment.getRequiredProperty("spring.redis.port")));
        jedisConnectionFactory.setHostName(environment.getRequiredProperty("spring.redis.host"));
        jedisConnectionFactory.setUsePool(Boolean.valueOf(environment.getRequiredProperty("spring.redis.use-pool")));
        return jedisConnectionFactory;
    }

    @Bean
    RedisTemplate< String, Object> redisTemplate() {
        final RedisTemplate< String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return redisTemplate;
    }

}
