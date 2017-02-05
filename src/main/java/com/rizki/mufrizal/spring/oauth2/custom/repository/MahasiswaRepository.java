package com.rizki.mufrizal.spring.oauth2.custom.repository;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Mahasiswa;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:18:21 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.repository
 *
 */
public interface MahasiswaRepository extends PagingAndSortingRepository<Mahasiswa, String> {

}
