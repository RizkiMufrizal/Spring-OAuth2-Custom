package com.rizki.mufrizal.spring.oauth2.custom.repository;

import com.rizki.mufrizal.spring.oauth2.custom.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:18:55 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.repository
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    @Query("select u from User u left join fetch u.userRoles pd where u.username = :username")
    User LoginUser(@Param("username") String username);

}
