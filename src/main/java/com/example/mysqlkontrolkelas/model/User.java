package com.example.mysqlkontrolkelas.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.example.mysqlkontrolkelas.repository.UserRepo;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Entity
@Table(name="user")
@Access(value=AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @NotBlank
    private String emailId;

    // Constructors
    public User() {

    }
    public User(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }
//    @JsonIgnore
//    @Column(nullable = false, updatable = false)
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    // Allows dd/MM/yyyy date to be passed into GET request in JSON
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date createdAt;
//
//    @JsonIgnore
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    // Allows dd/MM/yyyy date to be passed into GET request in JSON
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }

}
