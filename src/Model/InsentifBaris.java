package model;

import java.time.LocalDate;

public class InsentifBaris {
    private final Integer idInsentif;
    private final Integer idSertifikat;
    private final Integer nikPengguna;
    private final String  namaPengguna;
    private final Integer jumlahInsentif;
    private final LocalDate    tanggalCair;
    private final String  keterangan;

    public InsentifBaris(Integer idInsentif, Integer idSertifikat, Integer nikPengguna, String namaPengguna,
                       Integer jumlahInsentif, LocalDate tanggalCair, String keterangan) {
        this.idInsentif = idInsentif;
        this.idSertifikat = idSertifikat;
        this.nikPengguna = nikPengguna;
        this.namaPengguna = namaPengguna;
        this.jumlahInsentif = jumlahInsentif;
        this.tanggalCair = tanggalCair;
        this.keterangan = keterangan;
    }

    public Integer getIdInsentif() {
        return idInsentif;
    }

    public Integer getIdSertifikat() {
        return idSertifikat;
    }

    public Integer getNikPengguna() {
        return nikPengguna;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public Integer getJumlahInsentif() {
        return jumlahInsentif;
    }

    public LocalDate getTanggalCair() {
        return tanggalCair;
    }

    public String getKeterangan() {
        return keterangan;
    }
    
}
