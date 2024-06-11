package com.example.mysqlkontrolkelas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KontrolKelasStudentId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "kelas_idKelas")
    private int kontrolKelas;

    @ManyToOne
    @JoinColumn(name = "student_nim")
    private int student;

    private int nilaiAkhir;

    public KontrolKelasStudentId() {}
    public KontrolKelasStudentId(int kontrolKelas, int student ,int nilaiAkhir) {
        this.kontrolKelas = kontrolKelas;
        this.student = student;
        this.nilaiAkhir = nilaiAkhir;
    }

    public int getKontrolKelas() {
        return kontrolKelas;
    }

    public void setKontrolKelas(int kontrolKelas) {
        this.kontrolKelas = kontrolKelas;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(int nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KontrolKelasStudentId that = (KontrolKelasStudentId) o;
        return Objects.equals(kontrolKelas, that.kontrolKelas) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kontrolKelas, student);
    }
}