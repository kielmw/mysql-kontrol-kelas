package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public StudentService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public List<Student> getStudentsFromApi() {
        String url = "https://living-loon-tightly.ngrok-free.app/getStudent";
        String response = restTemplate.getForObject(url, String.class);

        try {
            List<StudentApiResponse> studentApiResponseList = objectMapper.readValue(response, new TypeReference<List<StudentApiResponse>>() {});
            return mapToStudentModel(studentApiResponseList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse API response");
        }
    }

    private List<Student> mapToStudentModel(List<StudentApiResponse> apiResponseList) {
        return apiResponseList.stream().map(apiResponse -> {
            Student student = new Student();
            student.setNim(apiResponse.getId());
            student.setNama(apiResponse.getStudentName());
            student.setNamaSekolah(apiResponse.getSchool().getSchoolName());
            return student;
        }).toList();
    }
}
