package com.nlw14.certification_nlw.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw14.certification_nlw.Entity.CertificationStudentEntity;
import com.nlw14.certification_nlw.Service.RankingtService;

@RestController
@RequestMapping("/ranking")

public class RankingController {

    @Autowired
    private RankingtService rs;


    @GetMapping("/best10")
    public List<CertificationStudentEntity> best10(){
        return this.rs.execute();
    }
    
}
