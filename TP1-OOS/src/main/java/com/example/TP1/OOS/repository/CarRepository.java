package com.example.TP1.OOS.repository;

import com.example.TP1.OOS.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}