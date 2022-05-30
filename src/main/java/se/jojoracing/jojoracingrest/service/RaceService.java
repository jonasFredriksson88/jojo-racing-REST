package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.entity.Result;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.repository.RaceRepository;
import se.jojoracing.jojoracingrest.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RaceService{

    private final RaceRepository raceRepository;
    private final UserRepository userRepository;


    public RaceService(RaceRepository raceRepository, UserRepository userRepository) {
        this.raceRepository = raceRepository;
        this.userRepository = userRepository;
    }

    public Race create(Race race) {
        return raceRepository.save(race);
    }

    public Race findById(Long id) {
        return raceRepository.findById(id).orElseThrow(); // TODO
    }

    public Race findByName(String name) {
        return raceRepository.findByNameIgnoreCase(name).orElseThrow(); // TODO
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
        User user = userRepository.findById(userId).orElseThrow();
        Result result = new Result();
        result.createLaps(race.getLaps());
        race.addRecord(result);
        user.addRecord(result);
        return race;
    }

    public Race removeUser(Long raceId, Long userId) {
        Race race = findById(raceId);
        return race;
    }
}
