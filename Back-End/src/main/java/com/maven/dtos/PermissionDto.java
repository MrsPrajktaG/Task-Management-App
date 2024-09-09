package com.maven.dtos;

import lombok.Data;

@Data
public class PermissionDto {
    private String modules;
    private Long id;
    private Boolean showPermission;
    private Boolean createPermission;
    private Boolean editPermission;
    private Boolean deletePermission;
}
