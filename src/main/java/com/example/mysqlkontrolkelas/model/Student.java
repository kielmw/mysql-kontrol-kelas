package com.example.mysqlkontrolkelas.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private int nim;

    @NotBlank
    private String nama;

    @OneToMany(mappedBy = "id.student")
    private Set<KontrolKelasStudent> kontrolKelasStudents = new HashSet<>();

    public Student() {}

    public Student(Long id, int nim, String nama) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Set<KontrolKelasStudent> getKontrolKelasStudents() {
        return kontrolKelasStudents;
    }

    public void setKontrolKelasStudents(Set<KontrolKelasStudent> kontrolKelasStudents) {
        this.kontrolKelasStudents = kontrolKelasStudents;
    }
}
