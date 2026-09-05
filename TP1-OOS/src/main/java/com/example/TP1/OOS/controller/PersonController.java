package com.example.TP1.OOS.controller;

import com.example.TP1.OOS.Person;
import com.example.TP1.OOS.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final CarService carService;

    public PersonController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return carService.addPerson(person);
    }

    @GetMapping
    public List<Person> listPersons() {
        return carService.listPersons();
    }
}