package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LabController {

    @GetMapping("/lab")
    public String labList(Model model){

        model.addAttribute("firstLab","lab-01-coupling");
        model.addAttribute("secondLab","lab-02-IoC");
        model.addAttribute("thirdLab","lab-03-DI");
        model.addAttribute("fourthLab","lab-04-springboot");
        model.addAttribute("fifthLab","lab-05-MVC");


        return "/lab/lab-list";
    }



}
