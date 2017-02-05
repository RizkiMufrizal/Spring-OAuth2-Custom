package com.rizki.mufrizal.spring.oauth2.custom.service;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Buku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:22:55 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service
 *
 */
public interface BukuService {

    public void saveBuku(Buku buku);

    public void updateBuku(Buku buku);

    public void deleteBuku(String idBuku);

    public Buku getBuku(String idBuku);

    public Page<Buku> getBukus(Pageable pageable);
}
