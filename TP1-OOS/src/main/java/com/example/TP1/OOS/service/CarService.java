
package com.example.TP1.OOS.service;

import com.example.TP1.OOS.CarNotFoundException;
import com.example.TP1.OOS.Car;
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

    public void rent(String plateNumber, boolean rent, String begin, String end)
            throws CarNotFoundException {
        Car car = findCar(plateNumber);
        car.setRented(rent);
        if (rent) {
        } else {
        }
    }
}