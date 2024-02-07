package com.nlw14.certification_nlw.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw14.certification_nlw.Entity.QuestionEntity;
import com.nlw14.certification_nlw.Repository.QuestionRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired 
    private QuestionRepository qr;

    @GetMapping("/technology/{technology}")
    public List<QuestionEntity> findByTechnology(@PathVariable String technology){
        return this.qr.findByTechnology(technology);
    }
}
