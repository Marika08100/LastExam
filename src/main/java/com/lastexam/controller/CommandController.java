package com.lastexam.controller;

import com.lastexam.model.Command;
import com.lastexam.model.Person;
import com.lastexam.model.Place;
import com.lastexam.service.EntityService;
import com.lastexam.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Data
@AllArgsConstructor
@RequestMapping("/command")
public class CommandController {
    private final EntityService entityService;
    private final PlaceService placeService;

    @GetMapping("/new/{personId}")
    public String createOrderForm(Model model, @PathVariable("personId") Integer personId) {
        model.addAttribute("personId", personId);
        model.addAttribute("command", new Command());
        return "order-form";
    }

    @PostMapping("/add/{personId}")
    public String createOrder(@ModelAttribute("command") Command command, @PathVariable("personId") Integer personId) {
        entityService.saveCommand(command);
        return "redirect:/commands";
    }


//    @GetMapping("/places")
//    public String listPlaces(Model model) {
//        List<Place> places = placeService.getAllPlaces();
//        model.addAttribute("places", places);
//        return "places";
//    }

}
