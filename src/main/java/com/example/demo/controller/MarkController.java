package com.example.demo.controller;

import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping("/admin/addingmark")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveNewMark(@RequestParam(value = "addmark") String nameOfNewMArk){
        markService.saveMark(nameOfNewMArk);
        return "redirect:/admin/add";
    }
}
