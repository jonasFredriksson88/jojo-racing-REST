package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Car;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.service.CarService;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        Car createdCar = carService.create(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        Car car = carService.findById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("custom")
    public ResponseEntity<Car> findCustom(@RequestParam String name) {
        Car user = carService.findByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = carService.getAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
