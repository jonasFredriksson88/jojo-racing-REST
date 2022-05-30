package se.jojoracing.jojoracingrest.repository;

import org.springframework.data.repository.CrudRepository;
import se.jojoracing.jojoracingrest.entity.Result;
import se.jojoracing.jojoracingrest.entity.User;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    List<Result> findAllByUser(User user);
}
