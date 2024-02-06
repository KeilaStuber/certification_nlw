package com.nlw14.certification_nlw;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")

public class FirstController {

    @GetMapping("/firstGet")
    public String getResult(){
        return "Creating my first get";
    }

    @PostMapping("firstPost")
    public String postResult(){
        return "Creating my first post";
    }

    @PutMapping("/firstPut")
    public String  putResult(){
        return "Creating my first put";
    }

    @DeleteMapping("/firstDelete")
    public String  deleteResult(){
        return "Creating my first delete";
    }

    
}
