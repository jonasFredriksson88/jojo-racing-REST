package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.repository.RaceRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
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
        Race race = raceRepository.findById(id).orElseThrow(); // TODO
        raceRepository.delete(race);
    }

}
