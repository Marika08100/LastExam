package com.lastexam.controller;

import com.lastexam.model.Person;
import com.lastexam.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class PersonController {

    private final EntityService entityService;



    @GetMapping("/create-person")
    public String createNewPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person-form";
    }

    @PostMapping("/person/add")
    public String createPerson(@ModelAttribute Person person) {
        entityService.savePerson(person);
        return "redirect:/home";
    }

    @PostMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer id) {
        entityService.deleteOrdersByPerson(entityService.getPersonById(id));
        entityService.deletePersonById(id);
        return "redirect:/home";
    }

    @GetMapping("/{personId}")
    public String getPersonById(Model model, @PathVariable Integer personId) {
        Person person = entityService.getPersonById(personId);
        model.addAttribute("person", person);
        return "person-update";
    }

    @PostMapping("/person/update/{personId}")
    public String updatePerson(@PathVariable("personId") Integer personId, @ModelAttribute("person") Person updatedPerson) {
        entityService.updatePerson(updatedPerson);
        return "redirect:/home";
    }
    @GetMapping("/statistics/allPersons")
    public String getAllPersonsWithOrders(Model model) {
        List<Person> allPersons = entityService.getAllPerson();
        model.addAttribute("allPersons", allPersons);
        return "person-statistics";
    }
    @GetMapping("/most-orders-person")
    public String mostOrdersPerson(Model model) {
        Person personWithMostCommands = entityService.findPersonWithMostCommands();
        model.addAttribute("person", personWithMostCommands);
        return "most-orders-person";
    }


}
