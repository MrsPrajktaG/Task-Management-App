package com.maven.Services;

import com.maven.Model.AdminGroups;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface AdminGroupsService {
    AdminGroups createGroup(AdminGroups groups);
    AdminGroups getGroupById(Long id);
    Set<AdminGroups> getAllGroups();
}
