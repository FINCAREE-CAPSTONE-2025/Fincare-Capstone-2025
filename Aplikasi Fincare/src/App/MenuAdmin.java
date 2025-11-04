package App;

import java.time.LocalDate;
import java.util.List;
import model.*;
import service.*;

public class MenuAdmin {

    private final Akun adminLogin;
    private final PelatihanService pelatihanSvc = new PelatihanService();
    private final PengajuanService pengajuanSvc = new PengajuanService();
    private final SertifikatService sertifikatSvc = new SertifikatService();
    private final InsentifService insentifSvc = new InsentifService();

    public MenuAdmin(Akun adminLogin) {
        this.adminLogin = adminLogin;
    }

    // CRUD Pelatihan
    public Pelatihan tambahPelatihan(String judul, String lembaga, LocalDate periode, int harga) {
        Pelatihan p = new Pelatihan();
        p.setNikAdmin(adminLogin.getNik());
        p.setJudul(judul);
        p.setLembaga(lembaga);
        p.setPeriode(periode);
        p.setHarga(harga);
        return pelatihanSvc.tambah(p);
    }

    public List<Pelatihan> semuaPelatihan() {
        return pelatihanSvc.temukanSemua();
    }

    public boolean hapusPelatihan(int id) {
        return pelatihanSvc.hapus(id);
    }

    public Pelatihan updatePelatihan(Pelatihan p) {
        return pelatihanSvc.perbarui(p);
    }

    // Verifikasi Pengajuan
    public void verifikasiPengajuan(int id, String status) {
        pengajuanSvc.ubahStatus(id, status, adminLogin.getNik());
    }

    public List<PengajuanBantuan> semuaPengajuan() {
        return pengajuanSvc.temukanSemua();
    }

    // Sertifikat
    public void verifikasiSertifikat(int idSertifikat, boolean diterima, String linkSertifikat) {
        sertifikatSvc.verifikasi(idSertifikat, diterima, linkSertifikat);
    }
    
    public void terimaSertifikat(int idSertifikat, String linkSertifikat) {
        verifikasiSertifikat(idSertifikat, true, linkSertifikat);
    }
    
    public void tolakSertifikat(int idSertifikat) {
        verifikasiSertifikat(idSertifikat, false, null);
    }

    public List<SertifikatPelatihan> semuaSertifikat() {
        return sertifikatSvc.temukanSemua();
    }
    
    public List<Object[]> cariSertifikatUntukVerifikasi(String keyword) {
        return sertifikatSvc.cariUntukVerifikasi(keyword);
    }

    // Insentif
    public List<Insentif> semuaInsentif() {
        return insentifSvc.temukanSemua();
    }
}
