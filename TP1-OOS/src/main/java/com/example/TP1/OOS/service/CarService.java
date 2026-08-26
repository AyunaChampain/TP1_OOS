
package com.example.TP1.OOS.service;

import com.example.TP1.OOS.CarNotFoundException;
import com.example.TP1.OOS.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("11AA22", "Ferrari", 100));
        cars.add(new Car("33BB44", "Renault", 40));
        cars.add(new Car("55CC66", "BMW", 80));
        cars.add(new Car("AA11BB", "Toyota", 60));
    }

    public List<Car> listOfCars() {
        return cars;
    }

    public Car findCar(String plateNumber) throws CarNotFoundException {
        return cars.stream()
                .filter(c -> c.getPlatenumber().equalsIgnoreCase(plateNumber))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException(plateNumber));
    }

    public void rentOrGetBack(String plateNumber, boolean rent, Dates date)
            throws CarNotFoundException {
        Car car = findCar(plateNumber);
        car.setRented(rent);
        if (rent) {
            car.setDate(date);
        } else {
            car.setDate(null);
        }
    }
}