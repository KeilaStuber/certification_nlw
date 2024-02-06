package com.nlw14.certification_nlw.Service;

import org.springframework.stereotype.Service;

import com.nlw14.certification_nlw.Dto.VerifyHasCertificationDto;

@Service
public class VerifyHasCertificationService {
    public boolean execute (VerifyHasCertificationDto dto){
        if (dto.getEmail() != null && dto.getEmail().equals("keila.stuberdev@gmail.com") && dto.getTechnology().equals("Java")){
            return true;
        }
        return false;
    }
}
