package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainUserController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AutoService autoService;
    @Autowired
    ModelService modelService;
    @Autowired
    BodyService bodyService;
    @Autowired
    TransmissionService transmissionService;
    @Autowired
    MotorService motorService;

    @GetMapping("/catalog")
    @PreAuthorize("hasAuthority('USER')")
    public String getAutoCatalog(org.springframework.ui.Model model,
                                 @RequestParam(value = "mark", required = false) Mark mark,
                                 @RequestParam(value = "model", required = false) Model autoModel,
                                 @RequestParam(value = "body", required = false) Body body,
                                 @RequestParam(value = "transmission", required = false) Transmission transmission,
                                 @RequestParam(value = "motor", required = false) Motor motor,
                                 @RequestParam(value = "minPrice", required = false, defaultValue = "0") int minPrice,
                                 @RequestParam(value = "maxPrice", required = false, defaultValue = "1000000") int maxPrice
                                 ){
        model.addAttribute("currentMark", mark);
        model.addAttribute("currentModel", autoModel);
        model.addAttribute("currentBody", body);
        model.addAttribute("currentTrans", transmission);
        model.addAttribute("currentMotor", motor);
        model.addAttribute("currentMinPrice", minPrice);
        model.addAttribute("currentMaxPrice", maxPrice);
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", modelService.getAllModel());
        model.addAttribute("bodys", bodyService.getAllBody());
        model.addAttribute("transmissions", transmissionService.getAllTransmission());
        model.addAttribute("motors", motorService.getAllMotor());
        List<Auto> autoList = null;
        if(mark != null && autoModel != null && body != null && transmission != null && motor != null ){
            autoList = autoService.getAutoByAllParam(mark.getId(), autoModel.getId(), body.getId(), motor.getId(), transmission.getId());
        } else if(mark != null && body != null && motor != null && transmission != null && autoModel == null){
            autoList = autoService.getAutoByMarkBodyMotorTrans(mark.getId(), body.getId(), motor.getId(), transmission.getId());
        } else if(mark != null && autoModel != null && motor != null && transmission != null && body == null){
            autoList = autoService.getAutoByMarkModelMotorTrans(mark.getId(), autoModel.getId(), motor.getId(), transmission.getId());
        } else if(mark != null && autoModel != null && body != null && transmission != null && motor == null){
            autoList = autoService.getAutoByMarkModelBodyTrans(mark.getId(), autoModel.getId(), body.getId(), transmission.getId());
        } else if(mark != null && autoModel != null && body != null && motor != null && transmission == null){
            autoList = autoService.getAutoByMarkModelBodyMotor(mark.getId(), autoModel.getId(), body.getId(), motor.getId());
        } else if(mark == null && autoModel == null && body != null && motor != null && transmission != null){
            autoList = autoService.getAutoByBodyMotorTrans(body.getId(), motor.getId(), transmission.getId());
        } else if(mark != null && body != null && motor != null && autoModel == null && transmission == null){
            autoList = autoService.getAutoByMarkBodyMotor(mark.getId(), body.getId(), motor.getId());
        } else if(mark != null && autoModel == null && body == null && motor != null && transmission != null){
            autoList = autoService.getAutoByMarkTransMotor(mark.getId(), transmission.getId(), motor.getId());
        } else if(mark != null && body != null && transmission != null && autoModel == null && motor == null){
            autoList = autoService.getAutoByMarkBodyTrans(mark.getId(), body.getId() , transmission.getId());
        } else if(mark != null && autoModel != null && body == null && transmission == null && motor != null){
            autoList = autoService.getAutoByMarkModelMotor(mark.getId(), autoModel.getId(), motor.getId());
        } else if(mark != null && autoModel != null && body == null && transmission != null && motor == null){
            autoList = autoService.getAutoByMarkModelTrans(mark.getId(), autoModel.getId(), transmission.getId());
        } else if(mark != null && autoModel != null && body != null && transmission == null && motor == null){
            autoList = autoService.getAutoByMarkModelBody(mark.getId(), autoModel.getId(), body.getId());
        } else if(mark == null && autoModel == null && body == null && transmission != null && motor != null){
            autoList = autoService.getAutoByTransMotor(transmission.getId(), motor.getId());
        } else if(mark == null && autoModel == null && body != null && motor == null && transmission != null){
            autoList = autoService.getAutoByBodyTrans(body.getId(), transmission.getId());
        } else if(mark == null && autoModel == null && body != null && transmission == null && motor != null){
            autoList = autoService.getAutoByBodyMotor(body.getId(), motor.getId());
        } else if(mark != null && autoModel == null && body == null && transmission == null && motor != null ){
            autoList = autoService.getAutoByMarkMotor(mark.getId(), motor.getId());
        } else if(mark != null && autoModel == null && body == null && transmission != null && motor == null){
            autoList = autoService.getAutoByMarkTrans(mark.getId(), transmission.getId());
        } else if (mark != null && autoModel == null && body != null && motor == null && transmission == null){
            autoList = autoService.getAutoByMarkBody(mark.getId(), body.getId());
        } else if(mark != null && autoModel != null && body == null && motor == null && transmission == null){
            autoList = autoService.getAutoByMarkModel(mark.getId(), autoModel.getId());
        } else if(mark == null && autoModel == null && body != null && transmission == null && motor == null){
            autoList = autoService.getAutoByBody(body.getId());
        } else if(mark == null && autoModel == null && body == null && transmission != null && motor == null){
            autoList = autoService.getAutoByTrans(transmission.getId());
        } else if(mark == null && autoModel == null && body == null && transmission == null && motor != null){
            autoList = autoService.getAutoByMotor(motor.getId());
        } else if(mark != null && autoModel == null && body == null && transmission == null && motor == null){
            autoList = autoService.getAutoByMark(mark.getId());
        } else {
            autoList = autoService.getAllAuto();
        }

        if(minPrice != 0 && maxPrice != 0){
            autoList = autoService.getAutoByPriceBetweenMinMax(autoList, minPrice, maxPrice);
        } else if(minPrice != 0 && maxPrice == 0){
            autoList = autoService.getAutoByPriceMin(autoList, minPrice);
        } else if(minPrice == 0 && maxPrice != 0){
            autoList = autoService.getAutoByPriceMax(autoList, maxPrice);
        }
        model.addAttribute("autoList", autoList);


        return "catalog";
    }
}
