package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Mahasiswa;
import com.rizki.mufrizal.spring.oauth2.custom.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 8:05:40 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
@RequestMapping(value = "/api")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping(value = "/mahasiswas")
    @CrossOrigin
    public HttpEntity<Page<Mahasiswa>> getMahasiswas(Pageable pageable) {
        return new ResponseEntity<>(mahasiswaService.getMahasiswas(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/mahasiswas/{idMahasiswa}")
    @CrossOrigin
    public HttpEntity<Mahasiswa> getMahasiswa(@PathVariable("idMahasiswa") String idMahasiswa) {
        return new ResponseEntity<>(mahasiswaService.getMahasiswa(idMahasiswa), HttpStatus.OK);
    }

}
