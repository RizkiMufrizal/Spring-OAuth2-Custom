package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Buku;
import com.rizki.mufrizal.spring.oauth2.custom.service.BukuService;
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
 * @Time 8:05:33 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping(value = "/bukus")
    @CrossOrigin
    public HttpEntity<Resources<Buku>> getBukus(Pageable pageable) {
        Resources<Buku> bukus = new Resources<>(bukuService.getBukus(pageable));
        bukus.add(linkTo(methodOn(BukuController.class).getBukus(pageable)).withSelfRel());

        return new ResponseEntity<>(bukus, HttpStatus.OK);
    }

    @GetMapping(value = "/bukus/{idBuku}")
    @CrossOrigin
    public HttpEntity<Resource<Buku>> getBuku(@PathVariable("idBuku") String idBuku) {
        Resource<Buku> buku = new Resource<>(bukuService.getBuku(idBuku));
        buku.add(linkTo(methodOn(BukuController.class).getBuku(idBuku)).withSelfRel());

        return new ResponseEntity<>(buku, HttpStatus.OK);
    }

}
