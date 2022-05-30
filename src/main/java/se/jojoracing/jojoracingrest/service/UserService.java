package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Car;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final CarService carService;


    public UserService(UserRepository userRepository, CarService carService) {
        this.userRepository = userRepository;
        this.carService = carService;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(); // TODO
    }

    public User findByName(String name) {
        return userRepository.findByNameIgnoreCase(name).orElseThrow(); // TODO
    }

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(); // TODO
        userRepository.delete(user);
    }

    public User addCar(Long userId, Long carId) {
        User user = findById(userId);
        Car car = carService.findById(carId);
        user.addCar(car);
        return user;
    }
}
