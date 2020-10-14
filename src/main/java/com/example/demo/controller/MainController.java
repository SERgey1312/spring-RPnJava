package com.example.demo.controller;

import com.example.demo.service.AutoService;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AutoService autoService;

    @GetMapping("/")
    public String getHomePage(org.springframework.ui.Model model){
        model.addAttribute("autoList", autoService.getAllAuto());
        model.addAttribute("order",true);
        return "index";
    }

    @GetMapping("/adding")
    public String addMarkModelOrBody(org.springframework.ui.Model model){
        model.addAttribute("marks", markService.getAllMark());
        return "add_some";
    }

}
