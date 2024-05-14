package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasService;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idKelas}")
    public ResponseEntity<KontrolKelas> getKontrolKelasById(@PathVariable int idKelas) {
        KontrolKelas kontrolKelas = kontrolKelasService.findKontrolKelasByIdKelas(idKelas);
        if (kontrolKelas != null) {
            return ResponseEntity.ok(kontrolKelas);
        }
        return ResponseEntity.notFound().build();
    }
}