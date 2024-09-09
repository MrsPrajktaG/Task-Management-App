package com.maven.Services.impl;

import com.maven.Model.AdminGroups;
import com.maven.Repository.AdminGroupsRepository;
import com.maven.Services.AdminGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminGroupsServiceImpl implements AdminGroupsService {
    @Autowired
    private AdminGroupsRepository groupsRepository;

    @Override
    public AdminGroups createGroup(AdminGroups groups) {
        groups.setCreated_date(LocalDate.now().toString());
        return groupsRepository.save(groups);
    }

    @Override
    public AdminGroups getGroupById(Long id) {
        return groupsRepository.getAdminGroupsById(id);
    }

    @Override
    public Set<AdminGroups> getAllGroups() {
        List<AdminGroups> all = groupsRepository.findAll();
        return new HashSet<>(all);
    }
}
