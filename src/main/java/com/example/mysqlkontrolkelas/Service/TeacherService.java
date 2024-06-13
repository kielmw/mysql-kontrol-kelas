package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.Teacher;
import com.example.mysqlkontrolkelas.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private static final String API_URL = "https://living-loon-tightly.ngrok-free.app/getTeacher";

    @Autowired
    private TeacherRepository teacherRepository;
    public List<Teacher> getTeachersFromApi() {
        RestTemplate restTemplate = new RestTemplate();
        TeacherApiResponse[] response = restTemplate.getForObject(API_URL, TeacherApiResponse[].class);
        return Arrays.stream(response).map(this::mapToTeacher).collect(Collectors.toList());
    }

    private Teacher mapToTeacher(TeacherApiResponse response) {
        Teacher teacher = new Teacher();
        teacher.setNip(Integer.parseInt(response.getId()));
        teacher.setNama(response.getTeacherName());
        teacher.setNamaSekolah(response.getSchool().getSchoolName());
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    private static class TeacherApiResponse {
        private String id;
        private String teacherName;
        private School school;

        // Getters and setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public School getSchool() {
            return school;
        }

        public void setSchool(School school) {
            this.school = school;
        }

        private static class School {
            private String schoolName;

            // Getters and setters

            public String getSchoolName() {
                return schoolName;
            }

            public void setSchoolName(String schoolName) {
                this.schoolName = schoolName;
            }
        }
    }
}
