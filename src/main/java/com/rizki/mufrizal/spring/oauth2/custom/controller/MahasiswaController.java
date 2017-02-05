package com.rizki.mufrizal.spring.oauth2.custom.controller;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Mahasiswa;
import com.rizki.mufrizal.spring.oauth2.custom.service.MahasiswaService;
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
 * @Time 8:05:40 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.controller
 *
 */
@RestController
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping(value = "/mahasiswas")
    @CrossOrigin
    public HttpEntity<Resources<Mahasiswa>> getMahasiswas(Pageable pageable) {
        Resources<Mahasiswa> mahasiswas = new Resources<>(mahasiswaService.getMahasiswas(pageable));
        mahasiswas.add(linkTo(methodOn(MahasiswaController.class).getMahasiswas(pageable)).withSelfRel());

        return new ResponseEntity<>(mahasiswas, HttpStatus.OK);
    }

    @GetMapping(value = "/mahasiswas/{idMahasiswa}")
    @CrossOrigin
    public HttpEntity<Resource<Mahasiswa>> getMahasiswa(@PathVariable("idMahasiswa") String idMahasiswa) {
        Resource<Mahasiswa> mahasiswa = new Resource<>(mahasiswaService.getMahasiswa(idMahasiswa));
        mahasiswa.add(linkTo(methodOn(MahasiswaController.class).getMahasiswa(idMahasiswa)).withSelfRel());

        return new ResponseEntity<>(mahasiswa, HttpStatus.OK);
    }

}
