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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_peminjaman", length = 36)
    private String idPeminjaman;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_peminjaman")
    private Date tanggalPeminjaman;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_batas_pengembalian")
    private Date tanggalBatasPengembalian;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "npm", insertable = false, updatable = false, nullable = false)
    private Mahasiswa mahasiswa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    /**
     * @return the idPeminjaman
     */
    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    /**
     * @param idPeminjaman the idPeminjaman to set
     */
    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    /**
     * @return the tanggalPeminjaman
     */
    public Date getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    /**
     * @param tanggalPeminjaman the tanggalPeminjaman to set
     */
    public void setTanggalPeminjaman(Date tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    /**
     * @return the tanggalBatasPengembalian
     */
    public Date getTanggalBatasPengembalian() {
        return tanggalBatasPengembalian;
    }

    /**
     * @param tanggalBatasPengembalian the tanggalBatasPengembalian to set
     */
    public void setTanggalBatasPengembalian(Date tanggalBatasPengembalian) {
        this.tanggalBatasPengembalian = tanggalBatasPengembalian;
    }

    /**
     * @return the mahasiswa
     */
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    /**
     * @param mahasiswa the mahasiswa to set
     */
    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    /**
     * @return the buku
     */
    public Buku getBuku() {
        return buku;
    }

    /**
     * @param buku the buku to set
     */
    public void setBuku(Buku buku) {
        this.buku = buku;
    }
}
