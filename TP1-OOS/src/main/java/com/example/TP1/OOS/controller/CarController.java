package com.example.TP1.OOS.controller;

import com.example.TP1.OOS.service.CarNotFoundException;
import com.example.TP1.OOS.Car;
import com.example.TP1.OOS.Dates;
import com.example.TP1.OOS.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.TP1.OOS.Person;
import java.util.Set;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> listOfCars() {
        return carService.listOfCars();
    }


    @GetMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws CarNotFoundException {
        return carService.findCar(plateNumber);
    }


    @PutMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody(required = false) Dates dates) throws CarNotFoundException {
        carService.rentOrGetBack(plateNumber, rent, dates);
    }

    @PostMapping("/{plateNumber}/passengers/{personId}")
    public Car addPassenger(@PathVariable String plateNumber, @PathVariable Long personId)
            throws CarNotFoundException {
        return carService.addPassengerToCar(plateNumber, personId);
    }

    @DeleteMapping("/{plateNumber}/passengers/{personId}")
    public Car removePassenger(@PathVariable String plateNumber, @PathVariable Long personId)
            throws CarNotFoundException {
        return carService.removePassengerFromCar(plateNumber, personId);
    }

    @GetMapping("/{plateNumber}/passengers")
    public Set<Person> getPassengers(@PathVariable String plateNumber) throws CarNotFoundException {
        return carService.getPassengers(plateNumber);
    }

}