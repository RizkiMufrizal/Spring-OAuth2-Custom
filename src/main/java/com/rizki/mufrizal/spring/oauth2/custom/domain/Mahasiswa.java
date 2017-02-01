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
 * @Since Feb 1, 2017
 * @Time 10:30:48 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "tb_mahasiswa")
public class Mahasiswa implements Serializable {

    @Id
    @Column(name = "npm")
    private String npm;

    @Column(name = "nama", length = 50, nullable = false)
    private String nama;

    @Column(name = "kelas", length = 6, nullable = false)
    private String kelas;

    @Column(name = "jenis_kelamin")
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;

    @Lob
    @Column(name = "alamat")
    private String alamat;
}
