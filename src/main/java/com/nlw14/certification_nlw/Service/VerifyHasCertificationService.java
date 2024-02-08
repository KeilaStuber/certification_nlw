package com.nlw14.certification_nlw.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw14.certification_nlw.Dto.VerifyHasCertificationDto;
import com.nlw14.certification_nlw.Repository.CertificationStudentRepository;

@Service
public class VerifyHasCertificationService {

    @Autowired
    private CertificationStudentRepository csr;

    public boolean execute (VerifyHasCertificationDto dto){

        var result = this.csr.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if (!result.isEmpty()){
            return true;
        }
        return false;
    }
}
