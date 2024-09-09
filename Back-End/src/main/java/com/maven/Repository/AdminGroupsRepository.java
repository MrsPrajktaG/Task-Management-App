package com.maven.Repository;

import com.maven.Model.AdminGroups;
import com.maven.Model.Categories;
import com.maven.Services.AdminGroupsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AdminGroupsRepository extends JpaRepository<AdminGroups,Long> {
    AdminGroups getAdminGroupsById(Long id);
}
