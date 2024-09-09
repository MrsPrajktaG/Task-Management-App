package com.maven.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
}
