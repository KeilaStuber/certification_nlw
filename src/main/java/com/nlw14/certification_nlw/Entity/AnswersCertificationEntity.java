package com.nlw14.certification_nlw.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="answers_certification")
public class AnswersCertificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "certification_id")
    private UUID certification_id;

    @ManyToOne()
    @JoinColumn(name = "certification_id" , insertable =false, updatable =false)
    private CertificationStudentEntity certificationStudentEntity;

    @Column(name = "student_id" , insertable =false, updatable =false)
    private UUID student_id;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @Column(name = "question_id")
    private UUID question_id;

    @Column(name = "answer_id")
    private UUID answer_id;

    @Column(name="is_correct ")
    private boolean isCorrect;
    
    @CreationTimestamp
    private LocalDateTime created_at;
}
