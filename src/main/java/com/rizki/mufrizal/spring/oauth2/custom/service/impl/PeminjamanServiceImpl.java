package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Peminjaman;
import com.rizki.mufrizal.spring.oauth2.custom.repository.PeminjamanRepository;
import com.rizki.mufrizal.spring.oauth2.custom.service.PeminjamanService;
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
 * @Time 7:29:36 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Transactional
    @Override
    public void savePeminjaman(Peminjaman peminjaman) {
        peminjamanRepository.save(peminjaman);
    }

    @Transactional
    @Override
    public void updatePeminjaman(Peminjaman peminjaman) {
        peminjamanRepository.save(peminjaman);
    }

    @Transactional
    @Override
    public void deletePeminjaman(String idPeminjaman) {
        peminjamanRepository.delete(idPeminjaman);
    }

    @Override
    public Peminjaman getPeminjaman(String idPeminjaman) {
        return peminjamanRepository.findOne(idPeminjaman);
    }

    @Override
    public Page<Peminjaman> getPeminjamans(Pageable pageable) {
        return peminjamanRepository.findAll(pageable);
    }

}
