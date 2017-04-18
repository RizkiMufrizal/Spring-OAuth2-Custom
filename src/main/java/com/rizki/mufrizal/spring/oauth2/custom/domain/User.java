package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 1, 2017
 * @Time 10:31:17 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Getter
    @Setter
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<>();
}
