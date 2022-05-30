package se.jojoracing.jojoracingrest.repository;

import org.springframework.data.repository.CrudRepository;
import se.jojoracing.jojoracingrest.entity.Car;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {
    Optional<Car> findByNameIgnoreCase(String name);
}
