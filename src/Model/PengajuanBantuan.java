package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pengajuan_bantuan")
public class PengajuanBantuan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pengajuan")
    private Integer idPengajuan;

    @ManyToOne
    @JoinColumn(name = "nik_pengguna", nullable = false)
    private Akun pengguna;

    @ManyToOne
    @JoinColumn(name = "nik_admin", nullable = true)
    private Admin admin;

    @Column(name = "id_pelatihan")
    private Integer idPelatihan;

    @Column(name = "alasan_pengajuan", nullable = false, columnDefinition = "TEXT")
    private String alasanPengajuan;

    @Column(name = "bidang_diminati", nullable = false, length = 100)
    private String bidangDiminati;

    @Column(name = "tanggal_pengajuan", nullable = false)
    private LocalDateTime tanggalPengajuan;

    @Column(name = "status_pengajuan", nullable = false, length = 10)
    private String statusPengajuan; // MENUNGGU | DITERIMA | DITOLAK

    public Integer getIdPengajuan() {
        return idPengajuan;
    }

    public void setIdPengajuan(Integer idPengajuan) {
        this.idPengajuan = idPengajuan;
    }

    public Akun getPengguna() {
        return pengguna;
    }

    public void setPengguna(Akun pengguna) {
        this.pengguna = pengguna;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Integer getIdPelatihan() {
        return idPelatihan;
    }

    public void setIdPelatihan(Integer idPelatihan) {
        this.idPelatihan = idPelatihan;
    }

    public String getAlasanPengajuan() {
        return alasanPengajuan;
    }

    public void setAlasanPengajuan(String alasanPengajuan) {
        this.alasanPengajuan = alasanPengajuan;
    }

    public String getBidangDiminati() {
        return bidangDiminati;
    }

    public void setBidangDiminati(String bidangDiminati) {
        this.bidangDiminati = bidangDiminati;
    }

    public LocalDateTime getTanggalPengajuan() {
        return tanggalPengajuan;
    }

    public void setTanggalPengajuan(LocalDateTime tanggalPengajuan) {
        this.tanggalPengajuan = tanggalPengajuan;
    }

    public String getStatusPengajuan() {
        return statusPengajuan;
    }

    public void setStatusPengajuan(String statusPengajuan) {
        this.statusPengajuan = statusPengajuan;
    }
    
}
