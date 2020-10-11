package com.example.demo.controller;

import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import com.example.demo.model.Model;
import com.example.demo.service.AutoService;
import com.example.demo.service.MarkService;
import com.example.demo.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AutoService autoService;

    @Autowired
    private ModelService modelService;

    @GetMapping("/")
    public String getHomePage(org.springframework.ui.Model model){
        model.addAttribute("autoList", autoService.getAllAuto());
        model.addAttribute("order",true);
        return "index";
    }

    @GetMapping("/add")
    public String addAuto(org.springframework.ui.Model model) {
        Auto auto = new Auto();
        List<Model> models = new ArrayList<Model>();
        model.addAttribute("auto", auto);
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", models);
        return "auto_add";
    }

    @PostMapping("/add")
    public @ResponseBody
    List<Model>
    addModels(@RequestBody int mark_id){
        return modelService.getAllModel();
    }

    @PostMapping("/save")
    public String saveAuto(@ModelAttribute("auto") Auto auto,
                           @RequestParam("mark")Mark mark) {
        autoService.saveAuto(auto, mark);
        return "redirect:/";
    }

}
