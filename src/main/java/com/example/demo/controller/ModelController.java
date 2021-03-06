package com.example.demo.controller;

import com.example.demo.model.Mark;
import com.example.demo.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/admin/addingmodel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveNewModel(@RequestParam(value = "addmodel") String nameOfNewModel,
                               @RequestParam(value = "mark") Mark mark
    ){
        modelService.saveNewModel(nameOfNewModel, mark);
        return "redirect:/admin/add";
    }

}
