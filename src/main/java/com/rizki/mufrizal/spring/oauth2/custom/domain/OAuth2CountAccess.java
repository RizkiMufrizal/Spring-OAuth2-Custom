package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 6, 2017
 * @Time 8:37:46 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "oauth_count_access")
public class OAuth2CountAccess implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "oauth_count_access")
    private String idOAuth2CountAccess;

    @Getter
    @Setter
    @Column(name = "count_access")
    private Integer countAccess;

    @Getter
    @Setter
    @Column(name = "client_id")
    private String clientId;
}
