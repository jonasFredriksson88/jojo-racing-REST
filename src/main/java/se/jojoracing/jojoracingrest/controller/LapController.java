package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jojoracing.jojoracingrest.dto.LapDTO;
import se.jojoracing.jojoracingrest.service.LapService;

import java.util.List;

import static se.jojoracing.jojoracingrest.utility.EntityMapper.lapToDTO;

@RestController
@RequestMapping("laps")
public class LapController {

    private final LapService lapService;

    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LapDTO> findById(@PathVariable Long id) {
        LapDTO lap = lapToDTO(lapService.findById(id));
        return new ResponseEntity<>(lap, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LapDTO>> getAll() {
        List<LapDTO> laps = lapToDTO(lapService.getAll());
        return new ResponseEntity<>(laps, HttpStatus.OK);
    }
}
