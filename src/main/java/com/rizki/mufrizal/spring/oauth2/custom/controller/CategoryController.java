package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.service.CategoryService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Jan 30, 2017
 * @Time 10:33:01 AM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/api/category")
    public Map<String, Object> getCategories(Pageable pageable) {
        return categoryService.getCategories(pageable);
    }

}
