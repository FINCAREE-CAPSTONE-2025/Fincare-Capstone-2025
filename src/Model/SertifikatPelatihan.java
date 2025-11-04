<<<<<<< HEAD
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sertifikat_pelatihan")
public class SertifikatPelatihan {
    @Id
    @Column(name = "id_sertifikat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSertifikat;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nik_pengguna", nullable = false)
    private Akun pengguna;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_pelatihan", nullable = true)
    private Pelatihan pelatihan;
    
    @Column(name = "tanggal_upload", nullable = false)
    private java.time.LocalDate tanggalUpload; 
    
    @Column(name = "status", nullable = false, length = 20)
    private String statusSertifikat = "MENUNGGU";

    @Column(name = "dokumen", length = 500)
    private String linkSertifikat;

    public Integer getIdSertifikat() {
        return idSertifikat;
    }

    public void setIdSertifikat(Integer idSertifikat) {
        this.idSertifikat = idSertifikat;
    }

    public Akun getPengguna() {
        return pengguna;
    }

    public void setPengguna(Akun pengguna) {
        this.pengguna = pengguna;
    }

    public Pelatihan getPelatihan() {
        return pelatihan;
    }

    public void setPelatihan(Pelatihan pelatihan) {
        this.pelatihan = pelatihan;
    }

    public LocalDate getTanggalUpload() {
        return tanggalUpload;
    }

    public void setTanggalUpload(LocalDate tanggalUpload) {
        this.tanggalUpload = tanggalUpload;
    }

    public String getStatusSertifikat() {
        return statusSertifikat;
    }

    public void setStatusSertifikat(String statusSertifikat) {
        this.statusSertifikat = statusSertifikat;
    }

    public String getLinkSertifikat() {
        return linkSertifikat;
    }

    public void setLinkSertifikat(String linkSertifikat) {
        this.linkSertifikat = linkSertifikat;
    }

    @Transient
    public boolean isFinalAccepted() {
        return "DITERIMA".equalsIgnoreCase(statusSertifikat);
    }
    
}
=======
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sertifikat_pelatihan")
public class SertifikatPelatihan {
    @Id
    @Column(name = "id_sertifikat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSertifikat;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nik_pengguna", nullable = false)
    private Akun pengguna;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_pelatihan", nullable = true)
    private Pelatihan pelatihan;
    
    @Column(name = "tanggal_upload", nullable = false)
    private java.time.LocalDate tanggalUpload; 
    
    @Column(name = "status", nullable = false, length = 20)
    private String statusSertifikat = "MENUNGGU";

    @Column(name = "dokumen", length = 500)
    private String linkSertifikat;

    public Integer getIdSertifikat() {
        return idSertifikat;
    }

    public void setIdSertifikat(Integer idSertifikat) {
        this.idSertifikat = idSertifikat;
    }

    public Akun getPengguna() {
        return pengguna;
    }

    public void setPengguna(Akun pengguna) {
        this.pengguna = pengguna;
    }

    public Pelatihan getPelatihan() {
        return pelatihan;
    }

    public void setPelatihan(Pelatihan pelatihan) {
        this.pelatihan = pelatihan;
    }

    public LocalDate getTanggalUpload() {
        return tanggalUpload;
    }

    public void setTanggalUpload(LocalDate tanggalUpload) {
        this.tanggalUpload = tanggalUpload;
    }

    public String getStatusSertifikat() {
        return statusSertifikat;
    }

    public void setStatusSertifikat(String statusSertifikat) {
        this.statusSertifikat = statusSertifikat;
    }

    public String getLinkSertifikat() {
        return linkSertifikat;
    }

    public void setLinkSertifikat(String linkSertifikat) {
        this.linkSertifikat = linkSertifikat;
    }

    @Transient
    public boolean isFinalAccepted() {
        return "DITERIMA".equalsIgnoreCase(statusSertifikat);
    }
    
}
>>>>>>> ffcfc0a90936944d338d2b3556aca9c95790d299
