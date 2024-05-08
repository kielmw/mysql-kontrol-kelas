package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasService;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class KontrolKelasController {

    private final KontrolKelasService kontrolKelasService;

    @Autowired
    public KontrolKelasController(KontrolKelasService kontrolKelasService) {
        this.kontrolKelasService = kontrolKelasService;
    }

    @PostMapping
    public KontrolKelas addKontrolKelas(@RequestBody KontrolKelas kontrolKelas) {
        return kontrolKelasService.addKontrolKelas(kontrolKelas);
    }

    @PutMapping("/{idKelas}")
    public ResponseEntity<KontrolKelas> updateKontrolKelas(@PathVariable int idKelas, @RequestBody KontrolKelas updatedKontrolKelas) {
        KontrolKelas updated = kontrolKelasService.updateKontrolKelas(idKelas, updatedKontrolKelas);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public Iterable<KontrolKelas> getAllKontrolKelas() {
        return kontrolKelasService.getAllKontrolKelas();
    }
}
