package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.KontrolKelasStudentService;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping
//    public ResponseEntity<KontrolKelasStudent> addStudentToKontrolKelas(@RequestParam int idKelas, @RequestParam int nim) {
//        KontrolKelasStudent kontrolKelasStudent = kontrolKelasStudentService.addStudentToKontrolKelas(idKelas, nim);
//        if (kontrolKelasStudent != null) {
//            return ResponseEntity.ok(kontrolKelasStudent);
//        }
//        return ResponseEntity.badRequest().build();
//    }

}
