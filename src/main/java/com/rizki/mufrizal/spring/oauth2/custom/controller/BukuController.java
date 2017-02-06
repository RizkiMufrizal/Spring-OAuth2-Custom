package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Buku;
import com.rizki.mufrizal.spring.oauth2.custom.service.BukuService;
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
 * @Time 8:05:33 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
@RequestMapping(value = "/api")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping(value = "/bukus")
    @CrossOrigin
    public HttpEntity<Page<Buku>> getBukus(Pageable pageable) {
        return new ResponseEntity<>(bukuService.getBukus(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/bukus/{idBuku}")
    @CrossOrigin
    public HttpEntity<Buku> getBuku(@PathVariable("idBuku") String idBuku) {
        return new ResponseEntity<>(bukuService.getBuku(idBuku), HttpStatus.OK);
    }

}
