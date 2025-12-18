package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class User {
@Id
private Long id;
private String name;
@Column( unique = true)
private String email;
private String password;
private String role;
}