package com.nlw14.certification_nlw.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StudentCertificationAnswerDto {
    private String email;
    private String technology;
    private List<QuestionAnswerDto> questionAnswer;
    
}
