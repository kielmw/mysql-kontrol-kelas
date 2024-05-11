package com.example.mysqlkontrolkelas.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nim;

    @NotBlank
    private String nama;

    @ManyToOne
    @JoinColumn(name = "kelas_id")
    private KontrolKelas kontrolKelas;

    public Student(Long id, String nim, String nama, KontrolKelas kontrolKelas) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.kontrolKelas = kontrolKelas;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public KontrolKelas getKontrolKelas() {
        return kontrolKelas;
    }

    public void setKontrolKelas(KontrolKelas kontrolKelas) {
        this.kontrolKelas = kontrolKelas;
    }
}