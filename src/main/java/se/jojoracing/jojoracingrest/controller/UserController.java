package se.jojoracing.jojoracingrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jojoracing.jojoracingrest.entity.Race;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.service.UserService;

import javax.persistence.NamedQuery;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("custom")
    public ResponseEntity<User> findCustom(@RequestParam String name) {
        User user = userService.findByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("{userId}/cars/{carId}/add")
    public ResponseEntity<User> addCar(@PathVariable Long userId, @PathVariable Long carId) {
        User user = userService.addCar(userId, carId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
