package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/admin/user")
    public String userList(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "userList";
    }

    @GetMapping("/admin/user/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("useR", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("/admin/user")
    public String saveUser(@RequestParam String username,
                           @RequestParam ("roles") Role role,
                           @RequestParam long id
    ){
        User user = userService.getUserById(id);
        user.setUsername(username);
        Set<Role> existsRole = user.getRoles();
        if(role.toString().equals("USER")){
            existsRole = new HashSet<Role>();
            existsRole.add(role);
        }
        if (role.toString().equals("ADMIN")){
            existsRole.add(role);
        }
        user.setRoles(existsRole);
        userService.saveUser(user);
        return "redirect:/admin/user";
    }
}
