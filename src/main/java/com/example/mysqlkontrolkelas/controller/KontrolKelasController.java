package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasService;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kontrol-kelas")
public class KontrolKelasController {

    @Autowired
    private KontrolKelasService kontrolKelasService;

    @PostMapping
    public ResponseEntity<KontrolKelas> createKontrolKelas(@RequestBody KontrolKelas kontrolKelas) {
        KontrolKelas savedKontrolKelas = kontrolKelasService.saveKontrolKelas(kontrolKelas);
        return ResponseEntity.ok(savedKontrolKelas);
    }

    @GetMapping
    public ResponseEntity<List<KontrolKelas>> getAllKontrolKelas() {
        List<KontrolKelas> kontrolKelasList = kontrolKelasService.findAllKontrolKelas();
        return ResponseEntity.ok(kontrolKelasList);
    }

    @GetMapping("/{idKelas}")
    public ResponseEntity<KontrolKelas> getKontrolKelasById(@PathVariable int idKelas) {
        KontrolKelas kontrolKelas = kontrolKelasService.findKontrolKelasByIdKelas(idKelas);
        if (kontrolKelas != null) {
            return ResponseEntity.ok(kontrolKelas);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{idKelas}")
    public ResponseEntity<KontrolKelas> updateKontrolKelas(@PathVariable int idKelas, @RequestBody KontrolKelas kontrolKelas) {
        KontrolKelas updatedKontrolKelas = kontrolKelasService.updateKontrolKelas(idKelas, kontrolKelas);
        if (updatedKontrolKelas != null) {
            return ResponseEntity.ok(updatedKontrolKelas);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{idKelas}")
    public ResponseEntity<Void> deleteKontrolKelas(@PathVariable int idKelas) {
        boolean isDeleted = kontrolKelasService.deleteKontrolKelasByIdKelas(idKelas);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}