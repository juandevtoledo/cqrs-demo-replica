package com.example.cqrsdemoreplica.service;

import com.example.cqrsdemoreplica.service.commands.CreateCarCommand;
import com.example.cqrsdemoreplica.service.commands.UpdateCarPriceCommand;

public interface CarCommandService {
    void handleCreateCarCommand(CreateCarCommand createCarCommand);
    void handleUpdateCarPriceCommand(UpdateCarPriceCommand updateCarPriceCommand);
}
