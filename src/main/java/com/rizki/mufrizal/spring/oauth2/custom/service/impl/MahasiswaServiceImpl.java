package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Mahasiswa;
import com.rizki.mufrizal.spring.oauth2.custom.repository.MahasiswaRepository;
import com.rizki.mufrizal.spring.oauth2.custom.service.MahasiswaService;
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
 * @Time 7:28:02 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Transactional
    @Override
    public void saveMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
    }

    @Transactional
    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
    }

    @Transactional
    @Override
    public void deleteMahasiswa(String idMahasiswa) {
        mahasiswaRepository.delete(idMahasiswa);
    }

    @Override
    public Mahasiswa getMahasiswa(String idMahasiswa) {
        return mahasiswaRepository.findOne(idMahasiswa);
    }

    @Override
    public Page<Mahasiswa> getMahasiswas(Pageable pageable) {
        return mahasiswaRepository.findAll(pageable);
    }

}
