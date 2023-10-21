package com.lastexam.controller;

import com.lastexam.model.Command;
import com.lastexam.model.Person;
import com.lastexam.model.Place;
import com.lastexam.service.EntityService;
import com.lastexam.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class Rest {

    private EntityService entityService;
    private PlaceService placeService;

    @GetMapping("/persons")
    public List<Person> getALlPerson() {
        return entityService.getAllPerson();
    }

    @GetMapping("/commands")
    public List<Command> getAllCommand() {
        return entityService.getAllCommand();
    }


    @GetMapping("/places")
    public List<Place> getAllPlace() {
        return placeService.getAllPlaces();
    }


}
