package com.example.mysqlkontrolkelas.controller;


import com.example.mysqlkontrolkelas.Service.KontrolKelasService;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/kontrolkelas")
public class KontrolKelasController {

    private final KontrolKelasService kontrolKelasService;

    @Autowired
    public KontrolKelasController(KontrolKelasService kontrolKelasService) {
        this.kontrolKelasService = kontrolKelasService;
    }

    @PostMapping
    public ResponseEntity<KontrolKelas> addKontrolKelas(@RequestBody KontrolKelas kontrolKelas) {
        KontrolKelas createdKontrolKelas = kontrolKelasService.addKontrolKelas(kontrolKelas);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKontrolKelas);
    }

    @PutMapping("/{idKelas}")
    public ResponseEntity<KontrolKelas> updateKontrolKelas(@PathVariable int idKelas, @RequestBody KontrolKelas updatedKontrolKelas) {
        KontrolKelas updatedEntity = kontrolKelasService.updateKontrolKelas(idKelas, updatedKontrolKelas);
        return ResponseEntity.ok(updatedEntity);
    }

    @GetMapping("/{idKelas}")
    public ResponseEntity<KontrolKelas> getKontrolKelas(@PathVariable int idKelas) {
        Optional<KontrolKelas> kontrolKelasOptional = kontrolKelasService.findKontrolKelasById(idKelas);
        return kontrolKelasOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
