package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.dto.UserDTO;
import se.jojoracing.jojoracingrest.service.UserService;

import java.util.List;

import static se.jojoracing.jojoracingrest.utility.EntityMapper.userToDTO;
import static se.jojoracing.jojoracingrest.utility.EntityMapper.userToEntity;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        UserDTO createdUser = userToDTO(userService.create(userToEntity(user)));
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO user = userToDTO(userService.findById(id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("custom")
    public ResponseEntity<UserDTO> findCustom(@RequestParam String name) {
        UserDTO user = userToDTO(userService.findByName(name));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> users = userToDTO(userService.getAll());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("{userId}/cars/{carId}/add")
    public ResponseEntity<UserDTO> addCar(@PathVariable Long userId, @PathVariable Long carId) {
        UserDTO user = userToDTO(userService.addCar(userId, carId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
