package com.nlw14.certification_nlw.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlw14.certification_nlw.Entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID>  {
    List<QuestionEntity> findByTechnology(String technology);
}
