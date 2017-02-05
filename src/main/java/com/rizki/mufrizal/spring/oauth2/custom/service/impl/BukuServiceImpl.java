package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Buku;
import com.rizki.mufrizal.spring.oauth2.custom.repository.BukuRepository;
import com.rizki.mufrizal.spring.oauth2.custom.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:25:46 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    @Transactional
    @Override
    public void saveBuku(Buku buku) {
        bukuRepository.save(buku);
    }

    @Transactional
    @Override
    public void updateBuku(Buku buku) {
        bukuRepository.save(buku);
    }

    @Transactional
    @Override
    public void deleteBuku(String idBuku) {
        bukuRepository.delete(idBuku);
    }

    @Override
    public Buku getBuku(String idBuku) {
        return bukuRepository.findOne(idBuku);
    }

    @Override
    public Page<Buku> getBukus(Pageable pageable) {
        return bukuRepository.findAll(pageable);
    }

}
