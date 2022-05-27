package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.service.RaceService;

import java.util.List;

@RestController
@RequestMapping("races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public ResponseEntity<Race> create(@RequestBody Race race) {
        Race createdRace = raceService.create(race);
        return new ResponseEntity<>(createdRace, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Race> findById(@PathVariable Long id) {
        Race race = raceService.findById(id);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Race>> getAll() {
        List<Race> laps = raceService.getAll();
        return new ResponseEntity<>(laps, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        raceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
