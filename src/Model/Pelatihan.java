<<<<<<< HEAD
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pelatihan")
public class Pelatihan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelatihan")
    private Integer idPelatihan;

    @Column(name = "nik_admin", nullable = false)
    private Integer nikAdmin;

    @Column(name = "judul_pelatihan", nullable = false)
    private String judul;

    @Column(name = "lembaga_pelatihan", nullable = false)
    private String lembaga;

    @Column(name = "periode", nullable = false)
    private LocalDate periode;

    @Column(name = "harga_pelatihan", nullable = false)
    private Integer harga;

    public Integer getIdPelatihan() {
        return idPelatihan;
    }

    public void setIdPelatihan(Integer idPelatihan) {
        this.idPelatihan = idPelatihan;
    }

    public Integer getNikAdmin() {
        return nikAdmin;
    }

    public void setNikAdmin(Integer nikAdmin) {
        this.nikAdmin = nikAdmin;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLembaga() {
        return lembaga;
    }

    public void setLembaga(String lembaga) {
        this.lembaga = lembaga;
    }

    public LocalDate getPeriode() {
        return periode;
    }

    public void setPeriode(LocalDate periode) {
        this.periode = periode;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

}
=======
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pelatihan")
public class Pelatihan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelatihan")
    private Integer idPelatihan;

    @Column(name = "nik_admin", nullable = false)
    private Integer nikAdmin;

    @Column(name = "judul_pelatihan", nullable = false)
    private String judul;

    @Column(name = "lembaga_pelatihan", nullable = false)
    private String lembaga;

    @Column(name = "periode", nullable = false)
    private LocalDate periode;

    @Column(name = "harga_pelatihan", nullable = false)
    private Integer harga;

    public Integer getIdPelatihan() {
        return idPelatihan;
    }

    public void setIdPelatihan(Integer idPelatihan) {
        this.idPelatihan = idPelatihan;
    }

    public Integer getNikAdmin() {
        return nikAdmin;
    }

    public void setNikAdmin(Integer nikAdmin) {
        this.nikAdmin = nikAdmin;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLembaga() {
        return lembaga;
    }

    public void setLembaga(String lembaga) {
        this.lembaga = lembaga;
    }

    public LocalDate getPeriode() {
        return periode;
    }

    public void setPeriode(LocalDate periode) {
        this.periode = periode;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
