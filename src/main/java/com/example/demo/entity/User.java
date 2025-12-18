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
public Long getId(){
    return Id;
}
public Long setId(){
    this.id=id;
}
public String getName(){
    return name;
}
public String setName(){
    
}
}