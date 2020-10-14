package com.example.demo.controller;

import com.example.demo.model.Auto;
import com.example.demo.model.Body;
import com.example.demo.model.Mark;
import com.example.demo.model.Model;
import com.example.demo.service.AutoService;
import com.example.demo.service.BodyService;
import com.example.demo.service.MarkService;
import com.example.demo.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutoController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AutoService autoService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BodyService bodyService;

    @GetMapping("/add")
    public String addAuto(org.springframework.ui.Model model) {
        Auto auto = new Auto();
        model.addAttribute("auto", auto);
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", modelService.getAllModel());
        model.addAttribute("bodys", bodyService.getAllBody());
        return "auto_add";
    }

    @PostMapping("/save")
    public String saveAuto(@ModelAttribute("auto") Auto auto,
                           @RequestParam("mark") Mark mark) {
        autoService.saveAuto(auto, mark);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuto(@PathVariable(value = "id") long id){
        autoService.deleteAutoById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateAuto(@PathVariable(value = "id") long id, org.springframework.ui.Model model){
        Auto auto =  autoService.getAutoById(id);
        model.addAttribute("auto", auto);
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", modelService.getAllModel());
        model.addAttribute("bodys", bodyService.getAllBody());
        model.addAttribute("marka", auto.getMark());
        return "auto_update";
    }

    @PostMapping("/update")
    public String updateOneAuto(@RequestParam(value = "id") long id,
                                @RequestParam(value = "mark") Mark mark,
                                @RequestParam(value = "model") Model model,
                                @RequestParam(value = "cost") int cost,
                                @RequestParam(value = "year") int year,
                                @RequestParam(value = "body") Body body
    ){
        Auto auto = autoService.getAutoById(id);
        auto.setMark(mark);
        auto.setYear(year);
        auto.setCost(cost);
        auto.setBody(body);
        auto.setModel(model);
        autoService.saveAuto(auto, auto.getMark());
        return "redirect:/";
    }

}
