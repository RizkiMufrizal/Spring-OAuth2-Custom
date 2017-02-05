package com.rizki.mufrizal.spring.oauth2.custom.service;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Mahasiswa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:24:23 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface MahasiswaService {

    public void saveMahasiswa(Mahasiswa mahasiswa);

    public void updateMahasiswa(Mahasiswa mahasiswa);

    public void deleteMahasiswa(String idMahasiswa);

    public Mahasiswa getMahasiswa(String idMahasiswa);

    public Page<Mahasiswa> getMahasiswas(Pageable pageable);
}
