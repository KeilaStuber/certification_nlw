package com.nlw14.certification_nlw.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw14.certification_nlw.Dto.VerifyHasCertificationDto;
import com.nlw14.certification_nlw.Service.VerifyHasCertificationService;

@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private VerifyHasCertificationService vhcs;

    @PostMapping("/verifyHasCertification")
    public String verifyHasCertificartion(@RequestBody VerifyHasCertificationDto verifyHasCertificationDto){
        var result = this.vhcs.execute(verifyHasCertificationDto);
        if(result) {
            return "The user can make the test";
        }

        return "The User can't make the test";
    }
    
    
}
