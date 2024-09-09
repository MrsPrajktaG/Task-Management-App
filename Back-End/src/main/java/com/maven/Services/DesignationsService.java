package com.maven.Services;

import com.maven.Model.Designations;
import org.springframework.stereotype.Service;

@Service
public interface DesignationsService {
    Designations adddesignations(Designations designations);
}
