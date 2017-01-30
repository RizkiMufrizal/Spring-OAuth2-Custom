package com.rizki.mufrizal.spring.oauth2.custom.service;

import java.util.TreeMap;
import org.springframework.data.domain.Pageable;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Jan 30, 2017
 * @Time 10:31:03 AM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface CategoryService {

    public TreeMap<String, Object> getCategories(Pageable pageable);
}
