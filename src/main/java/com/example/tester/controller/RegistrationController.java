package com.example.tester.controller;

import com.example.tester.domain.Role;
import com.example.tester.domain.User;
import com.example.tester.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(){
       return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> mode){
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB!=null){
          mode.put("message", "User exist");
          return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE));
        userRepo.save(user);
        return "redirect:/login";

    }
}

