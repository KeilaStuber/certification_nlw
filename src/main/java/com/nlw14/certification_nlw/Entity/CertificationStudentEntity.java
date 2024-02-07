package com.nlw14.certification_nlw.Entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "certification_student")
@NoArgsConstructor
@AllArgsConstructor

public class CertificationStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 10)
    private int grate;

    @Column(length = 100)
    private String technology;

    @JoinColumn(name = "student_id")
    private UUID student_id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", insertable =false, updatable =false)
    private StudentEntity studentEntity;

    @OneToMany
    @JoinColumn(name = "answer_certification_id" , insertable =false, updatable =false)

    List<AnswersCertificationEntity> answersCertificationEntity;

}
