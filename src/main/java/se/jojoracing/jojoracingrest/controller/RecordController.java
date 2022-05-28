package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.entity.Record;
import se.jojoracing.jojoracingrest.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Record> findById(@PathVariable Long id) {
        Record record = recordService.findById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Record>> getAll() {
        List<Record> users = recordService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
