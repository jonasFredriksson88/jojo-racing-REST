package se.jojoracing.jojoracingrest.repository;

import org.springframework.data.repository.CrudRepository;
import se.jojoracing.jojoracingrest.entity.Car;
import se.jojoracing.jojoracingrest.entity.Lap;

import java.util.Optional;

public interface LapRepository extends CrudRepository<Lap, Long> {
}
