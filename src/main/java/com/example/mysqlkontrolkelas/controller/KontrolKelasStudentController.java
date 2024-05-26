package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasStudentService;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentDTO;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/kontrol-kelas-student")
public class KontrolKelasStudentController {

    @Autowired
    private KontrolKelasStudentService kontrolKelasStudentService;

    @PostMapping
    public ResponseEntity<KontrolKelasStudent> addStudentToKontrolKelas(@RequestBody KontrolKelasStudentDTO dto) {
        KontrolKelasStudent kontrolKelasStudent = kontrolKelasStudentService.addStudentToKontrolKelas(dto.getIdKelas(), dto.getNim());
        if (kontrolKelasStudent != null) {
            return ResponseEntity.ok(kontrolKelasStudent);
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/{idKelas}")
    public ResponseEntity<KontrolKelasStudent> getStudentsByIdKelas(@PathVariable int idKelas) {
        Optional<KontrolKelasStudent> student = kontrolKelasStudentService.getStudentsByIdKelas(idKelas);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
    }


}
