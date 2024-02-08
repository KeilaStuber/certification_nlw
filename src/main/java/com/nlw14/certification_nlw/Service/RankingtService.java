package com.nlw14.certification_nlw.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw14.certification_nlw.Entity.CertificationStudentEntity;
import com.nlw14.certification_nlw.Repository.CertificationStudentRepository;

@Service
public class RankingtService {

    @Autowired
    private CertificationStudentRepository csr;

    public List<CertificationStudentEntity> execute(){
        var result= this.csr.findBest10ByOrderByGradeDesc();
        return result;
    }
    
}
