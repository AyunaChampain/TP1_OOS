package com.example.TP1.OOS.controller;

import com.example.TP1.OOS.CarNotFoundException;
import com.example.TP1.OOS.Car;
import com.example.TP1.OOS.Dates;
import com.example.TP1.OOS.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // GET .../cars
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> listOfCars() {
        return carService.listOfCars();
    }

    // GET .../cars/{plateNumber}
    @GetMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws CarNotFoundException {
        return carService.findCar(plateNumber);
    }

    // PUT .../cars/{plateNumber}?rent=true  (body: {"begin":"...","end":"..."})
    // PUT .../cars/{plateNumber}?rent=false
    @PutMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody(required = false) Dates dates) throws CarNotFoundException {

        String begin = (dates != null) ? dates.getBegin() : null;
        String end = (dates != null) ? dates.getEnd() : null;
        carService.rent(plateNumber, rent, begin, end);
    }

    // Handle "not found" cleanly
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(CarNotFoundException ex) {
        return ex.getMessage();
    }
}