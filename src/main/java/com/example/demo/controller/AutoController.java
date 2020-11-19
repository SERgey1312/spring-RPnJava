package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private TransmissionService transmissionService;
    @Autowired
    private MotorService motorService;

    @GetMapping("/admin/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addAuto(org.springframework.ui.Model model) {
        Auto auto = new Auto();
        model.addAttribute("auto", auto);
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", modelService.getAllModel());
        model.addAttribute("bodys", bodyService.getAllBody());
        model.addAttribute("motors", motorService.getAllMotor());
        model.addAttribute("transmissions", transmissionService.getAllTransmission());
        return "auto_add";
    }

    @PostMapping("/admin/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveAuto(@ModelAttribute("auto") Auto auto,
                           @RequestParam("mark") Mark mark) {
        autoService.saveAuto(auto, mark);
        return "redirect:/admin/auto";
    }

    @GetMapping("/admin/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteAuto(@PathVariable(value = "id") long id){
        autoService.deleteAutoById(id);
        return "redirect:/admin/auto";
    }

    @GetMapping("/admin/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateAuto(@PathVariable(value = "id") long id, org.springframework.ui.Model model){
        Auto auto =  autoService.getAutoById(id);
        model.addAttribute("auto", auto);
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", modelService.getAllModel());
        model.addAttribute("bodys", bodyService.getAllBody());
        model.addAttribute("transmissions", transmissionService.getAllTransmission());
        model.addAttribute("motors", motorService.getAllMotor());
        model.addAttribute("marka", auto.getMark());
        return "auto_update";
    }

    @PostMapping("/admin/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateOneAuto(@RequestParam(value = "id") long id,
                                @RequestParam(value = "mark") Mark mark,
                                @RequestParam(value = "model") Model model,
                                @RequestParam(value = "cost") int cost,
                                @RequestParam(value = "year") int year,
                                @RequestParam(value = "body") Body body,
                                @RequestParam(value = "photo_link") String photoLink,
                                @RequestParam(value = "motor") Motor motor,
                                @RequestParam(value = "transmission") Transmission transmission,
                                @RequestParam(value = "color") String color,
                                @RequestParam(value = "mileage") long mileage
                                ){
        Auto auto = autoService.getAutoById(id);
        auto.setMark(mark);
        auto.setYear(year);
        auto.setCost(cost);
        auto.setBody(body);
        auto.setModel(model);
        auto.setPhoto_link(photoLink);
        auto.setMotor(motor);
        auto.setTransmission(transmission);
        auto.setColor(color);
        auto.setMileage(mileage);
        autoService.saveAuto(auto, auto.getMark());
        return "redirect:/admin/auto";
    }

}
