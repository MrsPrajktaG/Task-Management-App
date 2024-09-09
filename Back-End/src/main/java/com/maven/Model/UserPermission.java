package com.maven.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permission")
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Boolean showPermission;
    private Boolean createPermission;
    private Boolean editPermission;
    private Boolean deletePermission;
    @ManyToOne
    @JsonIgnore
    private AdminGroups adminGroups;
    private String modules;


}
