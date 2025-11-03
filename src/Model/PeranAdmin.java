package model;

public class PeranAdmin implements Peran {
    @Override 
    public String kode() { 
        return "admin"; 
    }
    @Override 
    public boolean bolehVerifikasiPengajuan() { 
        return true; 
    }
    @Override 
    public boolean bolehKelolaPelatihan() {
        return true; 
    }
}
