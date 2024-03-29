package com.nlw14.certification_nlw.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw14.certification_nlw.Dto.StudentCertificationAnswerDto;
import com.nlw14.certification_nlw.Dto.VerifyHasCertificationDto;
import com.nlw14.certification_nlw.Service.StudentCertificationAnswerService;
import com.nlw14.certification_nlw.Service.VerifyHasCertificationService;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private VerifyHasCertificationService vhcs;

    @Autowired
    private StudentCertificationAnswerService sca;

    @PostMapping("/verifyHasCertification")
    public String verifyHasCertificartion(@RequestBody VerifyHasCertificationDto verifyHasCertificationDto){
        var result = this.vhcs.execute(verifyHasCertificationDto);
        if(result) {
            return "The user can make the test";
        }

        return "The User can't make the test";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer (@RequestBody StudentCertificationAnswerDto studentCertificationAnswerDto) throws Exception{
            try {
                var result = sca.execute(studentCertificationAnswerDto);
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        

    }
    
}
