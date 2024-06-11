package com.example.mysqlkontrolkelas.model;

public class KontrolKelasStudentDTO {
    private int idKelas;
    private int nim;
    private int nilaiAkhir;

    // Getters and Setters
    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(int nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }
}