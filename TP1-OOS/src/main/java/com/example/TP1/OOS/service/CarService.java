package com.example.TP1.OOS.service;

import com.example.TP1.OOS.Car;
import com.example.TP1.OOS.Dates;
import com.example.TP1.OOS.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TP1.OOS.Person;
import com.example.TP1.OOS.repository.PersonRepository;
import java.util.Set;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PersonRepository personRepository;

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

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> listPersons() {
        return personRepository.findAll();
    }

    public Car addPassengerToCar(String plateNumber, Long personId) throws CarNotFoundException {
        Car car = findCar(plateNumber);
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found: " + personId));
        car.getPassengers().add(person);
        return carRepository.save(car);
    }

    public Car removePassengerFromCar(String plateNumber, Long personId) throws CarNotFoundException {
        Car car = findCar(plateNumber);
        car.getPassengers().removeIf(p -> p.getId().equals(personId));
        return carRepository.save(car);
    }

    public Set<Person> getPassengers(String plateNumber) throws CarNotFoundException {
        return findCar(plateNumber).getPassengers();
    }
}