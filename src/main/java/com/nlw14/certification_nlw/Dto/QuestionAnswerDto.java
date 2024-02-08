package com.nlw14.certification_nlw.Dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class QuestionAnswerDto {

    private UUID question_id;
    private UUID alternative_id;
    private boolean isCorrect;

}
