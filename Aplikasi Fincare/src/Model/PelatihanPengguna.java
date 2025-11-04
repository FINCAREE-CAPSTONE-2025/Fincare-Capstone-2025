package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pelatihan_pengguna")
public class PelatihanPengguna {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nik_pengguna", nullable = false)
    private Akun pengguna;

    @ManyToOne
    @JoinColumn(name = "id_pelatihan", nullable = false)
    private Pelatihan pelatihan;

    @Column(nullable = false)
    private LocalDateTime tanggalBeli;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(LocalDateTime tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }
 
}

