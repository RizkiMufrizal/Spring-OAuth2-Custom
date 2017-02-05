package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 6:39:06 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "oauth_client_token")
public class OAuth2ClientToken implements Serializable {

    @Id
    @Column(name = "token_id", nullable = false)
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication_id")
    private String authenticationId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "client_id")
    private String clientId;

    /**
     * @return the tokenId
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * @param tokenId the tokenId to set
     */
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    /**
     * @return the token
     */
    public byte[] getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(byte[] token) {
        this.token = token;
    }

    /**
     * @return the authenticationId
     */
    public String getAuthenticationId() {
        return authenticationId;
    }

    /**
     * @param authenticationId the authenticationId to set
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
