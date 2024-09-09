package com.maven.Services.impl;

import com.maven.Model.Projects;
import com.maven.Repository.ProjectRepository;
import com.maven.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Projectimpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Projects addprojects(Projects projects) {
        return projectRepository.save(projects);
    }
}
