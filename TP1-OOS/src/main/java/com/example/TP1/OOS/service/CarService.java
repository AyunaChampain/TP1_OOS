package com.example.TP1.OOS.service;

import com.example.TP1.OOS.Car;
import com.example.TP1.OOS.Dates;
import com.example.TP1.OOS.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> listOfCars() {
        return carRepository.findAll();
    }

    public Car findCar(String plateNumber) throws CarNotFoundException {
        return carRepository.findById(plateNumber)
                .orElseThrow(() -> new CarNotFoundException(plateNumber));
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void rentOrGetBack(String plateNumber, boolean rent, Dates date)
            throws CarNotFoundException {
        Car car = findCar(plateNumber);
        car.setRented(rent);
        car.setDate(rent ? date : null);
        carRepository.save(car); // IMPORTANT : sans ça, le changement ne sera pas persisté
    }
}