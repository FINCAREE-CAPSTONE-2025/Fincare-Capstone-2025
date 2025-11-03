package model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pengguna")
public class Pengguna {
    public Pengguna() {} 
    @Id
    private Integer nik;

    @OneToOne
    @MapsId
    @JoinColumn(name = "nik", nullable = false, referencedColumnName = "nik")
    private Akun akun;

    @Column(nullable = false, length = 150)
    private String alamat;

    @Column(nullable = false, length = 100)
    private String pekerjaan;

    @Column(nullable = false)
    private Integer penghasilan;

    @Column(name = "tanggal_daftar")
    private Date tanggalDaftar;

    @Column(name = "saldo_akun")
    private Integer saldoAkun;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public Integer getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(Integer penghasilan) {
        this.penghasilan = penghasilan;
    }

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Date tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public Integer getSaldoAkun() {
        return saldoAkun;
    }

    public void setSaldoAkun(Integer saldoAkun) {
        this.saldoAkun = saldoAkun;
    }

    
}
