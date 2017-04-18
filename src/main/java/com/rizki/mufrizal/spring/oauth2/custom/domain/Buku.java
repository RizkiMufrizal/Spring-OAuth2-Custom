package com.rizki.mufrizal.spring.oauth2.custom.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 1, 2017
 * @Time 10:31:02 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.domain
 *
 */
@Entity
@Table(name = "tb_buku")
public class Buku implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_buku", length = 36)
    private String idBuku;

    @Getter
    @Setter
    @Column(name = "judul_buku", length = 50, nullable = false)
    private String judulBuku;

    @Getter
    @Setter
    @Column(name = "nama_pengarang", length = 50, nullable = false)
    private String namaPengarang;

    @Getter
    @Setter
    @Column(name = "tahun_terbit", nullable = false)
    private Integer tahunTerbit;

    @Getter
    @Setter
    @Column(name = "penerbit", length = 25, nullable = false)
    private String penerbit;

    @Getter
    @Setter
    @Column(name = "jumlah_buku", nullable = false)
    private String jumlahBuku;

    @Getter
    @Setter
    @Column(name = "nomor_rak_buku", length = 15, nullable = false)
    private String nomorRakBuku;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buku")
    private List<Peminjaman> peminjamans;
}
