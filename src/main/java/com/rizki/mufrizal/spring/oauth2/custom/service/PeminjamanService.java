package com.rizki.mufrizal.spring.oauth2.custom.service;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Peminjaman;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:25:05 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface PeminjamanService {

    public void savePeminjaman(Peminjaman peminjaman);

    public void updatePeminjaman(Peminjaman peminjaman);

    public void deletePeminjaman(String idPeminjaman);

    public Peminjaman getPeminjaman(String idPeminjaman);

    public Page<Peminjaman> getPeminjamans(Pageable pageable);
}
