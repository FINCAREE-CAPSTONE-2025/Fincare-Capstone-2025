package Model;

import java.time.LocalDateTime;

public class PengajuanBaris {
    public final Integer idPengajuan;
    public final Integer nikPengguna;
    public final String  nama;
    public final String pekerjaan;
    public final Integer penghasilan;
    public final String  bidangDiminati;
    public final LocalDateTime tanggalPengajuan;
    public final String  statusPengajuan;
    public final String  alasanPengajuan;
    public final Integer nikAdmin;

    public PengajuanBaris(Integer idPengajuan, Integer nikPengguna, String nama, String pekerjaan,
                        Integer penghasilan, String bidangDiminati, LocalDateTime tanggalPengajuan,
                        String statusPengajuan, String alasanPengajuan, Integer nikAdmin) {
        this.idPengajuan = idPengajuan;
        this.nikPengguna = nikPengguna;
        this.nama = nama;
        this.pekerjaan = pekerjaan;
        this.penghasilan = penghasilan;
        this.bidangDiminati = bidangDiminati;
        this.tanggalPengajuan = tanggalPengajuan;
        this.statusPengajuan = statusPengajuan;
        this.alasanPengajuan = alasanPengajuan;
        this.nikAdmin = nikAdmin;
    }
}
