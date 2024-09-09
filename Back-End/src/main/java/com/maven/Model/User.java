package com.maven.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private String image;
    @OneToOne
    private AdminGroups adminGroups;


}
