package com.example.demo.controller;

import com.example.demo.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BodyController {

    @Autowired
    private BodyService bodyService;

    @PostMapping("/admin/addingbody")
    public String saveNewBody(@RequestParam(value = "addbody") String nameOfBody){
        bodyService.saveBody(nameOfBody);
        return "redirect:/admin/add";
    }

}
