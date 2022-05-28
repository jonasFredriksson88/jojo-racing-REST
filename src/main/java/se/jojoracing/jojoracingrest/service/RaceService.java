package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.entity.Record;
import se.jojoracing.jojoracingrest.repository.RaceRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RaceService {

    private final RaceRepository raceRepository;
    private final RecordService recordService;


    public RaceService(RaceRepository raceRepository, RecordService recordService) {
        this.raceRepository = raceRepository;
        this.recordService = recordService;
    }

    public Race create(Race race) {
        return raceRepository.save(race);
    }

    public Race findById(Long id) {
        return raceRepository.findById(id).orElseThrow(); // TODO
    }

    public Race findByName(String name) {
        return raceRepository.findByName(name).orElseThrow(); // TODO
    }

    public List<Race> getAll() {
        return (List<Race>) raceRepository.findAll();
    }

    public void delete(Long id) {
        Race race = findById(id);
        raceRepository.delete(race);
    }

    public Race addUser(Long raceId, Long userId) {
        Race race = findById(raceId);
        Record record = recordService.create(race, userId);
        race.addRecord(record);

        return race;
    }
}
