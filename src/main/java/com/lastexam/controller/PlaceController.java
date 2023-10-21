package com.lastexam.controller;

import com.lastexam.model.Place;
import com.lastexam.service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public String listPlaces(Model model) {
        List<Place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);
        return "places";
    }
}
