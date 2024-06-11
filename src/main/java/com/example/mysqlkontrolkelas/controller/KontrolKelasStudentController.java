package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasStudentService;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kontrol-kelas-student")
public class KontrolKelasStudentController {

    @Autowired
    private KontrolKelasStudentService kontrolKelasStudentService;

    @PostMapping
    public ResponseEntity<KontrolKelasStudent> addStudentToKontrolKelas(@RequestBody KontrolKelasStudentDTO dto) {
        KontrolKelasStudent kontrolKelasStudent = kontrolKelasStudentService.addStudentToKontrolKelas(dto.getIdKelas(), dto.getNim() , dto.getNilaiAkhir());
        if (kontrolKelasStudent != null) {
            return ResponseEntity.ok(kontrolKelasStudent);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{idKelas}")
    public ResponseEntity<List<KontrolKelasStudent>> getStudentsByKontrolKelas(@PathVariable int idKelas) {
        List<KontrolKelasStudent> students = kontrolKelasStudentService.getStudentsByKontrolKelas(idKelas);
        if (students != null && !students.isEmpty()) {
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idKelas}/{nim}/{nilaiAkhir}")
    public ResponseEntity<Void> deleteKontrolKelasStudent(@PathVariable int idKelas, @PathVariable int nim , @PathVariable int nilaiAkhir) {
        boolean isDeleted = kontrolKelasStudentService.deleteKontrolKelasStudent(idKelas, nim , nilaiAkhir);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

//    @PutMapping("/{idKelas}/{nim}")
//    public ResponseEntity<KontrolKelasStudent> updateKontrolKelasStudent(@PathVariable int idKelas, @PathVariable int nim, @RequestBody KontrolKelasStudentDTO dto) {
//        KontrolKelasStudent updatedKontrolKelasStudent = kontrolKelasStudentService.updateKontrolKelasStudent(idKelas, nim, dto.getNilaiAkhir());
//        if (updatedKontrolKelasStudent != null) {
//            return ResponseEntity.ok(updatedKontrolKelasStudent);
//        }
//        return ResponseEntity.notFound().build();
//    }
}