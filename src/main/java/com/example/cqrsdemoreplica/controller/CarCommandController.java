package com.example.cqrsdemoreplica.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsdemoreplica.service.CarCommandService;
import com.example.cqrsdemoreplica.service.commands.CreateCarCommand;
import com.example.cqrsdemoreplica.service.commands.UpdateCarPriceCommand;

@RestController
@RequestMapping("/cars")
public class CarCommandController {

    private CarCommandService carCommandService;

    public CarCommandController(CarCommandService carCommandService) {
        this.carCommandService = carCommandService;
    }

    @PostMapping
    public void createCarCommand(@RequestBody  CreateCarCommand createCarCommand) {
        this.carCommandService.handleCreateCarCommand(createCarCommand);
    }

    @PutMapping("/{id}")
    public void updateCarCommand(@PathVariable("id") Long id, @RequestBody UpdateCarPriceCommand updateCarPriceCommand) {
        updateCarPriceCommand.setId(id);
        this.carCommandService.handleUpdateCarPriceCommand(updateCarPriceCommand);
    }
}
