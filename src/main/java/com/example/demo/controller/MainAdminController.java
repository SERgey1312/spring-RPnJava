package com.example.demo.controller;

import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import com.example.demo.model.Model;
import com.example.demo.model.Order;
import com.example.demo.service.AutoService;
import com.example.demo.service.MarkService;
import com.example.demo.service.ModelService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainAdminController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AutoService autoService;
    @Autowired
    ModelService modelService;
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String getHomePage(){
        return "homepage";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getAdminpanel(org.springframework.ui.Model model){
        return "admin_panel";
    }

    @GetMapping("/admin/auto")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdminPage(org.springframework.ui.Model model,
                               @RequestParam(value = "mark", required = false) Mark mark,
                               @RequestParam(value = "model", required = false) Model autoModel,
                               @RequestParam(value = "sortPrice", required = false, defaultValue = "no") String sortP,
                               @RequestParam(value = "sortYear", required = false, defaultValue = "no") String sortY
    ){
        model.addAttribute("marks", markService.getAllMark());
        model.addAttribute("models", modelService.getAllModel());
        model.addAttribute("currentMark", mark);
        model.addAttribute("currentModel", autoModel);

        List<Auto> autoList = null;
        if(mark == null && autoModel == null){
            autoList = autoService.getAllAuto();
        } else if(mark != null && autoModel == null){
            autoList = autoService.getAutoByMark(mark.getId());
        } else if(mark != null && autoModel != null){
            autoList = autoService.getAutoByModel(autoModel.getId());
        }
        if (sortP.equals("ASC") || sortP.equals("DSC")){
            autoList = autoService.sortByCost(autoList, sortP);
        }
        if(sortY.equals("ASC") || sortY.equals("DSC")){
            autoList = autoService.sortByYear(autoList, sortY);
        }
        model.addAttribute("autoList", autoList);
        model.addAttribute("sortPrice", sortP);
        model.addAttribute("sortYear", sortY);
        return "index";
    }

    @PostMapping

    @GetMapping("/admin/adding")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addMarkModelOrBody(org.springframework.ui.Model model){
        model.addAttribute("marks", markService.getAllMark());
        return "add_some";
    }

    @GetMapping("/admin/orders")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAllOrders(org.springframework.ui.Model model){
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders", orders);
        return "order_table";
    }

    @GetMapping("/admin/order/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteOrder(@PathVariable(value = "id") long id){
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }

}
