package com.nlw14.certification_nlw.Entity;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CertificationStudentEntity {
    private UUID id;
    private String technology;
    private int grate;
    List<AnswersCertificationEntity> answersCertificationEntity;
}
