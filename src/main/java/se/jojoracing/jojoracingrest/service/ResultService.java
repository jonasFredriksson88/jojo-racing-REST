package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Result;
import se.jojoracing.jojoracingrest.entity.User;
import se.jojoracing.jojoracingrest.repository.ResultRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResultService {

    private final ResultRepository resultRepository;
    private final UserService userService;

    public ResultService(ResultRepository resultRepository, UserService userService) {
        this.resultRepository = resultRepository;
        this.userService = userService;
    }

    public Result findById(Long id) {
        return resultRepository.findById(id).orElseThrow(); // TODO
    }

    public List<Result> getAll() {
        return (List<Result>) resultRepository.findAll();
    }

    public List<Result> getAllByUserId(Long userId) {
        User user = userService.findById(userId);
        return resultRepository.findAllByUser(user);
    }
}
