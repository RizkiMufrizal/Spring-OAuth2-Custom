package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 1, 2017
 * @Time 10:30:55 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "tb_peminjaman")
public class Peminjaman implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_peminjaman", length = 36)
    private String idPeminjaman;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_peminjaman")
    private Date tanggalPeminjaman;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_batas_pengembalian")
    private Date tanggalBatasPengembalian;

    @Getter
    @Setter
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "npm", insertable = false, updatable = false, nullable = false)
    private Mahasiswa mahasiswa;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_buku")
    private Buku buku;
}
