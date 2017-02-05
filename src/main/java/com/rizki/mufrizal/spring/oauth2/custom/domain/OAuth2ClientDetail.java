package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 6:23:12 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "oauth_client_details")
public class OAuth2ClientDetail implements Serializable {

    @Id
    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Column(name = "resource_ids", nullable = false)
    private String resourceIds;

    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    @Enumerated(EnumType.STRING)
    @Column(name = "scope", nullable = false)
    private Scope scope;

    @Enumerated(EnumType.STRING)
    @Column(name = "authorized_grant_types", nullable = false)
    private AuthorizedGrantTypes authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri", nullable = false)
    private String webServerRedirectUri;

    @Column(name = "authorities", nullable = false)
    private String Authorities;

    @Column(name = "access_token_validity", nullable = false)
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity", nullable = false)
    private Integer refreshTokenValidity;

    @Lob
    @Column(name = "additional_information", nullable = false)
    private String additionalInformation;

    @Column(name = "autoapprove", nullable = false)
    private Boolean autoApprove;

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

    /**
     * @return the resourceIds
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * @param resourceIds the resourceIds to set
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    /**
     * @return the clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @param clientSecret the clientSecret to set
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * @return the scope
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * @return the authorizedGrantTypes
     */
    public AuthorizedGrantTypes getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * @param authorizedGrantTypes the authorizedGrantTypes to set
     */
    public void setAuthorizedGrantTypes(AuthorizedGrantTypes authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    /**
     * @return the webServerRedirectUri
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * @param webServerRedirectUri the webServerRedirectUri to set
     */
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    /**
     * @return the Authorities
     */
    public String getAuthorities() {
        return Authorities;
    }

    /**
     * @param Authorities the Authorities to set
     */
    public void setAuthorities(String Authorities) {
        this.Authorities = Authorities;
    }

    /**
     * @return the accessTokenValidity
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * @param accessTokenValidity the accessTokenValidity to set
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * @return the refreshTokenValidity
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * @param refreshTokenValidity the refreshTokenValidity to set
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * @return the additionalInformation
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation the additionalInformation to set
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * @return the autoApprove
     */
    public Boolean getAutoApprove() {
        return autoApprove;
    }

    /**
     * @param autoApprove the autoApprove to set
     */
    public void setAutoApprove(Boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

}
