package com.maven.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "adminGroups")
    private List<UserPermission> userPermission;

}
