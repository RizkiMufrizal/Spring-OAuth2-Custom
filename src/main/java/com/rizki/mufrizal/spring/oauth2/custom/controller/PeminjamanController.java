package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Peminjaman;
import com.rizki.mufrizal.spring.oauth2.custom.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class PeminjamanController {

    @Autowired
    private PeminjamanService peminjamanService;

    @GetMapping(value = "/peminjamans")
    @CrossOrigin
    public HttpEntity<Resources<Peminjaman>> getPeminjamans(Pageable pageable) {
        Resources<Peminjaman> peminjamans = new Resources<>(peminjamanService.getPeminjamans(pageable));
        peminjamans.add(linkTo(methodOn(PeminjamanController.class).getPeminjamans(pageable)).withSelfRel());

        return new ResponseEntity<>(peminjamans, HttpStatus.OK);
    }

    @GetMapping(value = "/peminjamans/{idPeminjaman}")
    @CrossOrigin
    public HttpEntity<Resource<Peminjaman>> getPeminjaman(@PathVariable("idPeminjaman") String idPeminjaman) {
        Resource<Peminjaman> peminjaman = new Resource<>(peminjamanService.getPeminjaman(idPeminjaman));
        peminjaman.add(linkTo(methodOn(PeminjamanController.class).getPeminjaman(idPeminjaman)).withSelfRel());

        return new ResponseEntity<>(peminjaman, HttpStatus.OK);
    }

}
