package com.example.mysqlkontrolkelas.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "kontrolKelasDefault")
public class KontrolKelas {
    @NotBlank
    private String nim;
    @NotBlank
    private String nama;
    @NotBlank
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKelas;

    @NotBlank
    private String namaKelas;

    private int idEvaluasi;
    private String progressEvaluasi;

    // Constructors
    public KontrolKelas() {

    }

    public KontrolKelas(String nim, String nama, String role, String namaKelas) {
        this.nim = nim;
        this.nama = nama;
        this.role = role;
        this.namaKelas = namaKelas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
