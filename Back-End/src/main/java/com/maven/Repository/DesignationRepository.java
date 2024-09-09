package com.maven.Repository;

import com.maven.Model.Designations;
import com.maven.Model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designations,Long> {
}
