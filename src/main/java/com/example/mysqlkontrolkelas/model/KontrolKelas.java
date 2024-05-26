package com.example.mysqlkontrolkelas.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kelas")
public class KontrolKelas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKelas;

    @NotBlank
    private String namaKelas;

    @NotBlank
    private String deskripsiKelas;
    private int idEvaluasi;
    private String progressEvaluasi;
    private int idGuru;
    @NotBlank
    private String namaGuru;

    @OneToMany(mappedBy = "id.kontrolKelas")
    private Set<KontrolKelasStudent> kontrolKelasStudents = new HashSet<>();

    public KontrolKelas() {}

    public KontrolKelas(int idKelas, String namaKelas, String deskripsiKelas, int idEvaluasi, String progressEvaluasi, int idGuru, String namaGuru, Set<KontrolKelasStudent> kontrolKelasStudents) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.deskripsiKelas = deskripsiKelas;
        this.idEvaluasi = idEvaluasi;
        this.progressEvaluasi = progressEvaluasi;
        this.idGuru = idGuru;
        this.namaGuru = namaGuru;
        this.kontrolKelasStudents = kontrolKelasStudents;
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

    public String getDeskripsiKelas() {
        return deskripsiKelas;
    }

    public void setDeskripsiKelas(String deskripsiKelas) {
        this.deskripsiKelas = deskripsiKelas;
    }

    public int getIdEvaluasi() {
        return idEvaluasi;
    }

    public void setIdEvaluasi(int idEvaluasi) {
        this.idEvaluasi = idEvaluasi;
    }

    public String getProgressEvaluasi() {
        return progressEvaluasi;
    }

    public void setProgressEvaluasi(String progressEvaluasi) {
        this.progressEvaluasi = progressEvaluasi;
    }

    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public Set<KontrolKelasStudent> getKontrolKelasStudents() {
        return kontrolKelasStudents;
    }

    public void setKontrolKelasStudents(Set<KontrolKelasStudent> kontrolKelasStudents) {
        this.kontrolKelasStudents = kontrolKelasStudents;
    }
}
