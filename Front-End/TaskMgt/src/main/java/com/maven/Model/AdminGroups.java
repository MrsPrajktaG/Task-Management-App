package com.maven.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AdminGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String group_name;
    private String Created_date;
    private String description;

    @OneToMany(mappedBy = "adminGroups")
    @JsonBackReference
    private List<UserPermission> userPermission;

}
