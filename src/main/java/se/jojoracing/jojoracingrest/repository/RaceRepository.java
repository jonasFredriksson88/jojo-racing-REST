package se.jojoracing.jojoracingrest.repository;

import org.springframework.data.repository.CrudRepository;
import se.jojoracing.jojoracingrest.entity.Car;
import se.jojoracing.jojoracingrest.entity.Race;

import java.util.Optional;

public interface RaceRepository extends CrudRepository<Race, Long> {
    Optional<Race> findByName(String name);
}
