package com.nlw14.certification_nlw.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "certification_student")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CertificationStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 10)
    private int grade;

    @Column(length = 100)
    private String technology;

    @Column(name = "student_id")
    private UUID student_id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", insertable =false, updatable =false)
    @JsonManagedReference
    private StudentEntity studentEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_certification_id" , insertable =false, updatable =false)
    @JsonManagedReference
    List<AnswersCertificationEntity> answersCertificationEntity;

    @CreationTimestamp
    private LocalDateTime created_at;

}
