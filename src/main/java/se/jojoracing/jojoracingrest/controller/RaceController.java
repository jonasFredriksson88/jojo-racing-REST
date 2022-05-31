package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.dto.RaceDTO;
import se.jojoracing.jojoracingrest.service.RaceService;

import java.util.List;

import static se.jojoracing.jojoracingrest.utility.EntityMapper.raceToDTO;
import static se.jojoracing.jojoracingrest.utility.EntityMapper.raceToEntity;

@RestController
@RequestMapping("races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public ResponseEntity<RaceDTO> create(@RequestBody RaceDTO race) {
        RaceDTO createdRace = raceToDTO(raceService.create(raceToEntity(race)));
        return new ResponseEntity<>(createdRace, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RaceDTO> findById(@PathVariable Long id) {
        RaceDTO race = raceToDTO(raceService.findById(id));
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @GetMapping("custom")
    public ResponseEntity<RaceDTO> findCustom(@RequestParam String name) {
        RaceDTO race = raceToDTO(raceService.findByName(name));
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RaceDTO>> getAll() {
        List<RaceDTO> races = raceToDTO(raceService.getAll());
        return new ResponseEntity<>(races, HttpStatus.OK);
    }

    @PatchMapping("{raceId}/users/{userId}/add")
    public ResponseEntity<RaceDTO> addUser(@PathVariable Long raceId, @PathVariable Long userId) {
        RaceDTO race = raceToDTO(raceService.addUser(raceId, userId));
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @PatchMapping("{raceId}/users/{userId}/remove")
    public ResponseEntity<RaceDTO> removeUser(@PathVariable Long raceId, @PathVariable Long userId) {
        RaceDTO race = raceToDTO(raceService.removeUser(raceId, userId));
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        raceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
