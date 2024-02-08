package com.nlw14.certification_nlw.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw14.certification_nlw.Dto.StudentCertificationAnswerDto;
import com.nlw14.certification_nlw.Dto.VerifyHasCertificationDto;
import com.nlw14.certification_nlw.Entity.AnswersCertificationEntity;
import com.nlw14.certification_nlw.Entity.CertificationStudentEntity;
import com.nlw14.certification_nlw.Entity.QuestionEntity;
import com.nlw14.certification_nlw.Entity.StudentEntity;
import com.nlw14.certification_nlw.Repository.CertificationStudentRepository;
import com.nlw14.certification_nlw.Repository.QuestionRepository;
import com.nlw14.certification_nlw.Repository.StudentRepository;

@Service

public class StudentCertificationAnswerService {

    @Autowired 
    private StudentRepository sr;

    @Autowired 
    private QuestionRepository qr;

    @Autowired
    private CertificationStudentRepository csr;

    @Autowired
    private VerifyHasCertificationService vfs;

    public CertificationStudentEntity execute (StudentCertificationAnswerDto dto) throws Exception{

        var hasCertification = this.vfs.execute(new VerifyHasCertificationDto(dto.getEmail(),dto.getTechnology()));

        if (hasCertification) {
            throw new Exception("The student has a certification for this techonology");
        }

        //Get the alternatives and check if alternative is correct or not

        List<QuestionEntity> questionEntity = qr.findByTechnology(dto.getTechnology());
        List<AnswersCertificationEntity> answersCertification = new ArrayList<>();

        AtomicInteger correctAnswer = new AtomicInteger(0);

        dto.getQuestionAnswer()
        .stream().forEach(questionAnswer -> {
            var question = questionEntity.stream()
            .filter(q -> q.getId().equals(questionAnswer.getQuestion_id()))
            .findFirst().get();

            var findCorrectAlternative = question.getAlternative().stream()
            .filter(alternative -> alternative.isCorrect()).findFirst().get();

            if (findCorrectAlternative.getId().equals(questionAnswer.getAlternative_id())) {
                questionAnswer.setCorrect(true);

                correctAnswer.incrementAndGet();

            }else{
                questionAnswer.setCorrect(false);
            }

            var answerCertificationEntity = AnswersCertificationEntity.builder()
            .answer_id(questionAnswer.getAlternative_id())
            .question_id(questionAnswer.getQuestion_id())
            .isCorrect(questionAnswer.isCorrect()).build();

            answersCertification.add(answerCertificationEntity);
        });

        //Check if user exist for the email

        var student = sr.findByEmail(dto.getEmail());
        UUID studentId;
        if (student.isEmpty()) {
            var studentCreated = StudentEntity.builder().email(dto.getEmail()).build();
            studentCreated = sr.save(studentCreated);
            studentId = studentCreated.getId();
        }else {
            studentId = student.get().getId();
        }
        
        CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
        .technology(dto.getTechnology())
        .student_id(studentId)
        .answersCertificationEntity(answersCertification)
        .grade(correctAnswer.get())
        .build();

        var certificationStudentCreated = csr.save(certificationStudentEntity);

        answersCertification.stream().forEach(answerCertification ->{
            answerCertification.setCertification_id(certificationStudentEntity.getId());
            answerCertification.setCertificationStudentEntity(certificationStudentEntity);
        });
        certificationStudentEntity.setAnswersCertificationEntity(answersCertification);
        return certificationStudentCreated;


        //Save the informations of certification

    }
    
}