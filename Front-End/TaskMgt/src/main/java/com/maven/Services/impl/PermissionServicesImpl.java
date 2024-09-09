package com.maven.Services.impl;

import com.maven.Model.User;
import com.maven.Model.UserPermission;
import com.maven.Repository.PermissionRepository;
import com.maven.Services.PermissionService;
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
    public UserPermission updatePermissionsByAdminGroupIdAndPermissionId(Long pid, UserPermission permission) {
        UserPermission userPermissionById = permissionRepository.getUserPermissionById(19L);
        System.out.println(userPermissionById);
//        if(userPermissionById!=null){
//            userPermissionById.setShowPermission(permission.getShowPermission());
//            userPermissionById.setCreatePermission(permission.getCreatePermission());
//            userPermissionById.setEditPermission(permission.getEditPermission());
//            userPermissionById.setDeletePermission(permission.getDeletePermission());
//        }
//        assert userPermissionById != null;
//        return permissionRepository.save(userPermissionById);
        return userPermissionById;
    }
}
