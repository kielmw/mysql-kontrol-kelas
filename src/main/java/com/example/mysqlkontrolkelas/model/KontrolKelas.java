package com.example.mysqlkontrolkelas.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kontrolKelasDefault")
public class KontrolKelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKelas;

    @NotBlank
    private String namaKelas;

    @OneToMany(mappedBy = "kontrolKelas", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    private int idEvaluasi;
    private String progressEvaluasi;

    public KontrolKelas() {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.students = students;
        this.idEvaluasi = idEvaluasi;
        this.progressEvaluasi = progressEvaluasi;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}
