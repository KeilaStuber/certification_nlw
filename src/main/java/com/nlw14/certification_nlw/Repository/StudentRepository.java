package com.nlw14.certification_nlw.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nlw14.certification_nlw.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID>{
    
    public Optional<StudentEntity> findByEmail(String email);
}
