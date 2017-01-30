package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Department;
import com.rizki.mufrizal.spring.oauth2.custom.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Jan 30, 2017
 * @Time 10:33:22 AM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/api/department")
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentService.getDepartments(pageable);
    }

}
