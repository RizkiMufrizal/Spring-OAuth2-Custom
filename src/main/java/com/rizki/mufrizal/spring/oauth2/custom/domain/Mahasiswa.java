package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    @Column(name = "npm")
    private String npm;

    @Getter
    @Setter
    @Column(name = "nama", length = 50, nullable = false)
    private String nama;

    @Getter
    @Setter
    @Column(name = "kelas", length = 6, nullable = false)
    private String kelas;

    @Getter
    @Setter
    @Column(name = "jenis_kelamin")
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;

    @Getter
    @Setter
    @Lob
    @Column(name = "alamat")
    private String alamat;

    @Getter
    @Setter
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "mahasiswa")
    private List<Peminjaman> peminjamans = new ArrayList<>();
}
