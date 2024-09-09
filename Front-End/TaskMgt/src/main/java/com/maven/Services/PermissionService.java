package com.maven.Services;

import com.maven.Model.UserPermission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService {
    UserPermission setPermissions(UserPermission permission);
    List<UserPermission> getAllPermissionsByGroupId(Long id);
    UserPermission updatePermissionsByAdminGroupIdAndPermissionId(Long gid, UserPermission userPermission);
}
