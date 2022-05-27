package se.jojoracing.jojoracingrest.service;

import org.apache.coyote.Response;
import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(); // TODO
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(); // TODO
    }

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(); // TODO
        userRepository.delete(user);
    }

}
