package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.service.RaceService;
import se.jojoracing.jojoracingrest.service.UserService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("custom")
    public ResponseEntity<Race> findCustom(@RequestParam String name) {
        Race race = raceService.findByName(name);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Race>> getAll() {
        List<Race> races = raceService.getAll();
        return new ResponseEntity<>(races, HttpStatus.OK);
    }

    @PatchMapping("{raceId}/users/{userId}/add")
    public ResponseEntity<Race> addUser(@PathVariable Long raceId,@PathVariable Long userId) {
        Race race = raceService.addUser(raceId,userId);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @PatchMapping("{raceId}/users/{userId}/remove")
    public ResponseEntity<Race> removeUser(@PathVariable Long raceId,@PathVariable Long userId) {
        Race race = raceService.removeUser(raceId,userId);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        raceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
