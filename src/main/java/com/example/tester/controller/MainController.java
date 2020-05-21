package com.example.tester.controller;

import com.example.tester.domain.Message;
import com.example.tester.domain.User;
import com.example.tester.repo.MessageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
  @Autowired
    MessageRep messageRepo;

    @GetMapping("/")
    public String greeting(Model model){
        return "greeting";
    }
    @GetMapping("/main")
    public String main (@RequestParam(required = false, defaultValue = " ") String filter, Model model){
        Iterable<Message> messages = messageRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Model model){
        Message message = new Message(text,tag,user);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

}
