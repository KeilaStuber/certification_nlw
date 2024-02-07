package com.nlw14.certification_nlw.Controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw14.certification_nlw.Dto.AlternativeResultDto;
import com.nlw14.certification_nlw.Dto.QuestionResultDto;
import com.nlw14.certification_nlw.Entity.AlternativeEntity;
import com.nlw14.certification_nlw.Entity.QuestionEntity;
import com.nlw14.certification_nlw.Repository.QuestionRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired 
    private QuestionRepository qr;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDto> findByTechnology(@PathVariable String technology){
        System.out.println("Tech === "+ technology);
        var result = this.qr.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionDto(question)).collect(Collectors.toList());

        return toMap;
    }

    static QuestionResultDto mapQuestionDto (QuestionEntity question){
       var questionResultDto = QuestionResultDto.builder()
       .id(question.getId())
       .technology(question.getTechnology())
       .description(question.getDescription()).build();

       List<AlternativeResultDto> alternativeResultDtos = question.getAlternative().stream().map(alternative -> 
       mapAlternativeDto(alternative)).collect(Collectors.toList());
       questionResultDto.setAlternative(alternativeResultDtos);
       return questionResultDto;
    }

    static AlternativeResultDto mapAlternativeDto(AlternativeEntity alternativeResultDto){
        return AlternativeResultDto.builder()
        .id(alternativeResultDto.getId())
        .description(alternativeResultDto.getDescription()).build();
       

    }
}
