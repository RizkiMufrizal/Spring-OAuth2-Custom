package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "oauth_count_access")
    private String idOAuth2CountAccess;

    @Column(name = "count_access")
    private Integer countAccess;

    @Column(name = "client_id")
    private String clientId;

    /**
     * @return the idOAuth2CountAccess
     */
    public String getIdOAuth2CountAccess() {
        return idOAuth2CountAccess;
    }

    /**
     * @param idOAuth2CountAccess the idOAuth2CountAccess to set
     */
    public void setIdOAuth2CountAccess(String idOAuth2CountAccess) {
        this.idOAuth2CountAccess = idOAuth2CountAccess;
    }

    /**
     * @return the countAccess
     */
    public Integer getCountAccess() {
        return countAccess;
    }

    /**
     * @param countAccess the countAccess to set
     */
    public void setCountAccess(Integer countAccess) {
        this.countAccess = countAccess;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
