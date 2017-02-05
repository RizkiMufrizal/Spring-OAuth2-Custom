package com.rizki.mufrizal.spring.oauth2.custom.repository;

import com.rizki.mufrizal.spring.oauth2.custom.domain.Buku;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:18:07 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.repository
 *
 */
public interface BukuRepository extends PagingAndSortingRepository<Buku, String> {

}
