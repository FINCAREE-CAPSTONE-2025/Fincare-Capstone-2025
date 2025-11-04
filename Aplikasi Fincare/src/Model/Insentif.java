<<<<<<< HEAD
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "insentif")
public class Insentif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insentif")
    private Integer idInsentif;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_sertifikat", nullable = false, unique = true)
    private SertifikatPelatihan sertifikat;

    @Column(name = "jumlah_insentif", nullable = false)
    private Integer jumlahInsentif;

    @Column(name = "tanggal_cair", nullable = false)
    private LocalDate tanggalCair;

    @Column(name = "keterangan", nullable = false, length = 200)
    private String keterangan;

    public Integer getIdInsentif() {
        return idInsentif;
    }

    public void setIdInsentif(Integer idInsentif) {
        this.idInsentif = idInsentif;
    }

    public SertifikatPelatihan getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(SertifikatPelatihan sertifikat) {
        this.sertifikat = sertifikat;
    }

    public Integer getJumlahInsentif() {
        return jumlahInsentif;
    }

    public void setJumlahInsentif(Integer jumlahInsentif) {
        this.jumlahInsentif = jumlahInsentif;
    }

    public LocalDate getTanggalCair() {
        return tanggalCair;
    }

    public void setTanggalCair(LocalDate tanggalCair) {
        this.tanggalCair = tanggalCair;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
=======
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "insentif")
public class Insentif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insentif")
    private Integer idInsentif;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_sertifikat", nullable = false, unique = true)
    private SertifikatPelatihan sertifikat;

    @Column(name = "jumlah_insentif", nullable = false)
    private Integer jumlahInsentif;

    @Column(name = "tanggal_cair", nullable = false)
    private LocalDate tanggalCair;

    @Column(name = "keterangan", nullable = false, length = 200)
    private String keterangan;

    public Integer getIdInsentif() {
        return idInsentif;
    }

    public void setIdInsentif(Integer idInsentif) {
        this.idInsentif = idInsentif;
    }

    public SertifikatPelatihan getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(SertifikatPelatihan sertifikat) {
        this.sertifikat = sertifikat;
    }

    public Integer getJumlahInsentif() {
        return jumlahInsentif;
    }

    public void setJumlahInsentif(Integer jumlahInsentif) {
        this.jumlahInsentif = jumlahInsentif;
    }

    public LocalDate getTanggalCair() {
        return tanggalCair;
    }

    public void setTanggalCair(LocalDate tanggalCair) {
        this.tanggalCair = tanggalCair;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
