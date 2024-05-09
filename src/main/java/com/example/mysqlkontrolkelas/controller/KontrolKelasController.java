package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasService;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<KontrolKelas> addKontrolKelas(@RequestBody KontrolKelas kontrolKelas) {
        KontrolKelas createdKontrolKelas = kontrolKelasService.addKontrolKelas(kontrolKelas);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKontrolKelas);
    }
}
