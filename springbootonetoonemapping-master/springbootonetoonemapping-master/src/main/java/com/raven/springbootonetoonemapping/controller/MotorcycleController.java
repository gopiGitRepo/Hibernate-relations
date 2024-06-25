package com.raven.springbootonetoonemapping.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raven.springbootonetoonemapping.entiry.Engine;
import com.raven.springbootonetoonemapping.entiry.Motorcycle;
import com.raven.springbootonetoonemapping.repository.EngineRepo;
import com.raven.springbootonetoonemapping.repository.MotorcycleRepository;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    @Autowired
    private MotorcycleRepository motorcycleRepository;
    
    @Autowired
    private EngineRepo engineRepo;

    // TO SAVE
    @PostMapping("/saveMotorcycle")
    public Motorcycle saveMotorcycle(@RequestBody Motorcycle motorcycle) {
        System.out.println("Motorcycle save called...");
        Motorcycle outMotorcycle = motorcycleRepository.save(motorcycle);
        System.out.println("Saved Motorcycle :: " + outMotorcycle);

        return outMotorcycle;
    }

    // TO GET
    @GetMapping("/getMotorcycle/{id}")
    public Optional<Motorcycle> getMotorcycle(@PathVariable String id) {
        System.out.println("Motorcycle get() called...");
        Optional<Motorcycle> outMotorcycle = motorcycleRepository.findById(Integer.valueOf(id));
        System.out.println("Motorcycle with Engine :: " + outMotorcycle);

        return outMotorcycle;
    }
    
    @GetMapping("/getEngine/{id}")
    public String getEngine(@PathVariable String id) {
        System.out.println("Motorcycle get() called...");
        Optional<Engine> outMotorcycle = engineRepo.findById(Integer.valueOf(id));
        
        
        System.out.println("Motorcycle with Engine :: " + outMotorcycle.get().getMotorCycle());

        return "fetched";
    }
}
