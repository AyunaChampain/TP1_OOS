package com.example.TP1.OOS.repository;

import com.example.TP1.OOS.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}