package com.example.mysqlkontrolkelas.model;

import javax.persistence.*;
import java.io.Serializable;

@jakarta.persistence.Entity
@Table(name = "kontrol_kelas_student")
public class KontrolKelasStudent {
    @jakarta.persistence.EmbeddedId
    private KontrolKelasStudentId id;

    private int nilaiAkhir;

    public KontrolKelasStudent() {}

    public KontrolKelasStudent(KontrolKelasStudentId id) {
        this.id = id;
    }

    public KontrolKelasStudentId getId() {
        return id;
    }

    public void setId(KontrolKelasStudentId id) {
        this.id = id;
    }

    public int getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(int nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }
}
