package com.maven.Services.impl;

import com.maven.Model.User;
import com.maven.Model.UserPermission;
import com.maven.Repository.PermissionRepository;
import com.maven.Services.PermissionService;
import com.maven.dtos.PermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServicesImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserPermission setPermissions(UserPermission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<UserPermission> getAllPermissionsByGroupId(Long id) {
        return permissionRepository.getAllByAdminGroupsId(id);
    }

    @Override
    public UserPermission updatePermissionsByPermissionId(PermissionDto permissionDto) {
        UserPermission userPermissionById = permissionRepository.getUserPermissionById(permissionDto.getId());


        return permissionRepository.save(userPermissionById);

    }
}
