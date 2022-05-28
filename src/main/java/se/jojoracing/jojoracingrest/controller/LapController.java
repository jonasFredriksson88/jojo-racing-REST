package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Lap;
import se.jojoracing.jojoracingrest.service.LapService;

import java.util.List;

@RestController
@RequestMapping("laps")
public class LapController {

    private final LapService lapService;

    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Lap> findById(@PathVariable Long id) {
        Lap lap = lapService.findById(id);
        return new ResponseEntity<>(lap, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Lap>> getAll() {
        List<Lap> laps = lapService.getAll();
        return new ResponseEntity<>(laps, HttpStatus.OK);
    }
}
