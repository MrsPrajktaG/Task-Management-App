package com.maven.Services.impl;

import com.maven.Model.Designations;
import com.maven.Repository.DesignationRepository;
import com.maven.Services.DesignationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Designationimpl implements DesignationsService {
    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public Designations adddesignations(Designations designations) {
        return designationRepository.save(designations);
    }
}
