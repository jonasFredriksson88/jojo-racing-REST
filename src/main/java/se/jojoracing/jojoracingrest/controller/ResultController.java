package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jojoracing.jojoracingrest.dto.ResultDTO;
import se.jojoracing.jojoracingrest.service.ResultService;

import java.util.List;

import static se.jojoracing.jojoracingrest.utility.EntityMapper.resultToDTO;

@RestController
@RequestMapping("records")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ResultDTO> findById(@PathVariable Long id) {
        ResultDTO result = resultToDTO(resultService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResultDTO>> getAll() {
        List<ResultDTO> result = resultToDTO(resultService.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<ResultDTO>> getAllByUserId(@PathVariable Long userId) {
        List<ResultDTO> results = resultToDTO(resultService.getAllByUserId(userId));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
