package com.rizki.mufrizal.spring.oauth2.custom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 1, 2017
 * @Time 10:31:23 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "tb_user_role")
public class UserRole implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_role_id", length = 36, nullable = false)
    private String userRoleId;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 15, nullable = false)
    private Role role;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user;
}
