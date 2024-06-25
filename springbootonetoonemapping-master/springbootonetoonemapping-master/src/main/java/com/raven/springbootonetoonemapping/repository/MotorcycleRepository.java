package com.raven.springbootonetoonemapping.repository;

import com.raven.springbootonetoonemapping.entiry.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

    @Override
    Optional<Motorcycle> findById(Integer id);
}
