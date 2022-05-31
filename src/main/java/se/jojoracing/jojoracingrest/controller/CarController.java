package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.dto.CarDTO;
import se.jojoracing.jojoracingrest.service.CarService;

import java.util.List;

import static se.jojoracing.jojoracingrest.utility.EntityMapper.carToDTO;
import static se.jojoracing.jojoracingrest.utility.EntityMapper.carToEntity;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO car) {
        CarDTO createdCar = carToDTO(carService.create(carToEntity(car)));
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable Long id) {
        CarDTO car = carToDTO(carService.findById(id));
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("custom")
    public ResponseEntity<CarDTO> findCustom(@RequestParam String name) {
        CarDTO car = carToDTO(carService.findByName(name));
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll() {
        List<CarDTO> cars = carToDTO(carService.getAll());
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
