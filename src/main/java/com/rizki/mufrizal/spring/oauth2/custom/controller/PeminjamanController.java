package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Peminjaman;
import com.rizki.mufrizal.spring.oauth2.custom.service.PeminjamanService;
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
 * @Time 8:05:47 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
@RequestMapping(value = "/api")
public class PeminjamanController {

    @Autowired
    private PeminjamanService peminjamanService;

    @GetMapping(value = "/peminjamans")
    @CrossOrigin
    public HttpEntity<Page<Peminjaman>> getPeminjamans(Pageable pageable) {
        return new ResponseEntity<>(peminjamanService.getPeminjamans(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/peminjamans/{idPeminjaman}")
    @CrossOrigin
    public HttpEntity<Peminjaman> getPeminjaman(@PathVariable("idPeminjaman") String idPeminjaman) {
        return new ResponseEntity<>(peminjamanService.getPeminjaman(idPeminjaman), HttpStatus.OK);
    }

}
