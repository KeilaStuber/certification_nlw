package com.nlw14.certification_nlw.Dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class QuestionResultDto {
    private UUID id;
    private String technology;
    private String description;

    private List<AlternativeResultDto> alternative;
}
