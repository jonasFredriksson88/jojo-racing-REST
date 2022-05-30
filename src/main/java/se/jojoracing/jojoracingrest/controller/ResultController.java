package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Result;
import se.jojoracing.jojoracingrest.service.ResultService;

import java.util.List;

@RestController
@RequestMapping("records")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Result> findById(@PathVariable Long id) {
        Result result = resultService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Result>> getAll() {
        List<Result> result = resultService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Result>> getAllByUserId(@PathVariable Long userId) {
        List<Result> results = resultService.getAllByUserId(userId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
