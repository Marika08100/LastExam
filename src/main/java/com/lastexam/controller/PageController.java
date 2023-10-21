package com.lastexam.controller;

import com.lastexam.model.Command;
import com.lastexam.model.Person;
import com.lastexam.service.EntityService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PageController {
    private EntityService entityService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        List<Person> persons = entityService.getAllPerson();
        model.addAttribute("persons", persons);
        return "home";
    }

    @GetMapping("/commands")
    public String listCommands(Model model) {
        List<Command> commands = entityService.getAllCommand();
        model.addAttribute("commands", commands);
        return "command";
    }

}
