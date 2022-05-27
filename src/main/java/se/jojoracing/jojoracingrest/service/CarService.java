package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Car;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.repository.CarRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(); // TODO
    }

    public Car findByName(String name) {
        return carRepository.findByName(name).orElseThrow(); // TODO
    }

    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }

    public void delete(Long id) {
        Car car = carRepository.findById(id).orElseThrow(); // TODO
        carRepository.delete(car);
    }

}
