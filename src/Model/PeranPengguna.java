package model;

public class PeranPengguna implements Peran {
    @Override 
    public String kode() {
        return "pengguna"; 
    }
    @Override 
    public boolean bolehVerifikasiPengajuan() {
        return false; 
    }
    @Override 
    public boolean bolehKelolaPelatihan() { 
        return false; 
    }
}
