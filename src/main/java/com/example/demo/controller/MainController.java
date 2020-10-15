package com.example.demo.controller;

import com.example.demo.service.AutoService;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AutoService autoService;

    @GetMapping("/")
    public String getHomePage(){
        return "homepage";
    }

    @GetMapping("/admin/auto")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdminPage(org.springframework.ui.Model model){
        model.addAttribute("autoList", autoService.getAllAuto());
        model.addAttribute("order",true);
        return "index";
    }

    @GetMapping("/admin/adding")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addMarkModelOrBody(org.springframework.ui.Model model){
        model.addAttribute("marks", markService.getAllMark());
        return "add_some";
    }

}
