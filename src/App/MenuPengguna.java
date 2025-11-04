<<<<<<< HEAD
package App;

import java.util.List;
import model.*;
import service.*;

public class MenuPengguna {

    private final Akun penggunaLogin;
    private final PengajuanService pengajuanSvc = new PengajuanService();
    private final PelatihanService pelatihanSvc = new PelatihanService();
    private final SertifikatService sertifikatSvc = new SertifikatService();
    private final InsentifService insentifSvc = new InsentifService();

    public MenuPengguna(Akun penggunaLogin) {
        this.penggunaLogin = penggunaLogin;
    }

    // Pengajuan bantuan baru
    public PengajuanBantuan ajukanBantuan(String alasan, String bidang) {
        PengajuanBantuan pb = new PengajuanBantuan();
        pb.setPengguna(penggunaLogin);
        pb.setAlasanPengajuan(alasan);
        pb.setBidangDiminati(bidang);
        return pengajuanSvc.tambah(pb);
    }

    public List<PengajuanBantuan> lihatPengajuan() {
        return pengajuanSvc.temukanSemua()
                .stream()
                .filter(p -> p.getPengguna().getNik().equals(penggunaLogin.getNik()))
                .toList();
    }

    // Pelatihan
    public List<Pelatihan> semuaPelatihan() {
        return pelatihanSvc.temukanSemua();
    }

    // Sertifikat
    public List<SertifikatPelatihan> lihatSertifikat() {
        return sertifikatSvc.temukanSemua()
                .stream()
                .filter(s -> s.getPengguna().getNik().equals(penggunaLogin.getNik()))
                .toList();
    }

    // Insentif
    public List<Insentif> lihatInsentif() {
        return insentifSvc.temukanSemua()
                .stream()
                .filter(i -> i.getSertifikat().getPengguna().getNik().equals(penggunaLogin.getNik()))
                .toList();
    }
}
=======
package App;

import java.util.List;
import model.*;
import service.*;

public class MenuPengguna {

    private final Akun penggunaLogin;
    private final PengajuanService pengajuanSvc = new PengajuanService();
    private final PelatihanService pelatihanSvc = new PelatihanService();
    private final SertifikatService sertifikatSvc = new SertifikatService();
    private final InsentifService insentifSvc = new InsentifService();

    public MenuPengguna(Akun penggunaLogin) {
        this.penggunaLogin = penggunaLogin;
    }

    // Pengajuan bantuan baru
    public PengajuanBantuan ajukanBantuan(String alasan, String bidang) {
        PengajuanBantuan pb = new PengajuanBantuan();
        pb.setPengguna(penggunaLogin);
        pb.setAlasanPengajuan(alasan);
        pb.setBidangDiminati(bidang);
        return pengajuanSvc.tambah(pb);
    }

    public List<PengajuanBantuan> lihatPengajuan() {
        return pengajuanSvc.temukanSemua()
                .stream()
                .filter(p -> p.getPengguna().getNik().equals(penggunaLogin.getNik()))
                .toList();
    }

    // Pelatihan
    public List<Pelatihan> semuaPelatihan() {
        return pelatihanSvc.temukanSemua();
    }

    // Sertifikat
    public List<SertifikatPelatihan> lihatSertifikat() {
        return sertifikatSvc.temukanSemua()
                .stream()
                .filter(s -> s.getPengguna().getNik().equals(penggunaLogin.getNik()))
                .toList();
    }

    // Insentif
    public List<Insentif> lihatInsentif() {
        return insentifSvc.temukanSemua()
                .stream()
                .filter(i -> i.getSertifikat().getPengguna().getNik().equals(penggunaLogin.getNik()))
                .toList();
    }
}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
