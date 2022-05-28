package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.entity.Record;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.repository.RecordRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecordService {

    private final RecordRepository recordRepository;
    private final UserService userService;

    public RecordService(RecordRepository recordRepository, UserService userService) {
        this.recordRepository = recordRepository;
        this.userService = userService;
    }

    public Record create(Race race, Long userId) {
        Record record = new Record();
        User user = userService.findById(userId);
        record.addUser(user);
        record.createLaps(race.getLaps());

        return recordRepository.save(record);
    }

    public Record findById(Long id) {
        return recordRepository.findById(id).orElseThrow(); // TODO
    }

    public List<Record> getAll() {
        return (List<Record>) recordRepository.findAll();
    }

}
