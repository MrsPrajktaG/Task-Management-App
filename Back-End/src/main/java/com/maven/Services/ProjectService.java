package com.maven.Services;

import com.maven.Model.Projects;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    Projects addprojects(Projects projects);
}
