package com.example.mysqlkontrolkelas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KontrolKelasStudentId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "kelas_idKelas")
    private KontrolKelas kontrolKelas;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public KontrolKelasStudentId() {}
    public KontrolKelasStudentId(KontrolKelas kontrolKelas, Student student) {
        this.kontrolKelas = kontrolKelas;
        this.student = student;
    }

    public KontrolKelas getKontrolKelas() {
        return kontrolKelas;
    }

    public void setKontrolKelas(KontrolKelas kontrolKelas) {
        this.kontrolKelas = kontrolKelas;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // Equals and HashCode (required for @Embeddable class)
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

