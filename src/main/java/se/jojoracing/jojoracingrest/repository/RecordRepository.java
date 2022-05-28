package se.jojoracing.jojoracingrest.repository;

import org.springframework.data.repository.CrudRepository;
import se.jojoracing.jojoracingrest.entity.Record;

public interface RecordRepository extends CrudRepository<Record, Long> {
}
