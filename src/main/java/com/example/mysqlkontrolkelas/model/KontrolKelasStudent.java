package com.example.mysqlkontrolkelas.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@jakarta.persistence.Entity
@Table(name = "kontrol_kelas_student")
public class KontrolKelasStudent {
    @jakarta.persistence.EmbeddedId
    private KontrolKelasStudentId id;

    public KontrolKelasStudent() {
    }

    public KontrolKelasStudent(KontrolKelasStudentId id) {
        this.id = id;
    }

    public KontrolKelasStudentId getId() {
        return id;
    }

    public void setId(KontrolKelasStudentId id) {
        this.id = id;
    }


}
