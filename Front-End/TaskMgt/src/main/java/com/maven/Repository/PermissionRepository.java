package com.maven.Repository;

import com.maven.Model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<UserPermission,Long> {

    List<UserPermission> getAllByAdminGroupsId(Long id);
    UserPermission getUserPermissionById(Long id);

//    @Query("UPDATE UserPermission u SET u =: permission WHERE u.id =: pId")
//    UserPermission updateUserPermissionByAdminGroups_Id(UserPermission permission, Long pId);
}
