package se.jojoracing.jojoracingrest.service;

import org.springframework.stereotype.Service;
import se.jojoracing.jojoracingrest.entity.Car;
import se.jojoracing.jojoracingrest.entity.Lap;
import se.jojoracing.jojoracingrest.repository.LapRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LapService {

    private final LapRepository lapRepository;

    public LapService(LapRepository lapRepository) {
        this.lapRepository = lapRepository;
    }

    public Lap create(Lap car) {
        return lapRepository.save(car);
    }

    public Lap findById(Long id) {
        return lapRepository.findById(id).orElseThrow(); // TODO
    }

    public List<Lap> getAllUsers() {
        return (List<Lap>) lapRepository.findAll();
    }

    public void delete(Long id) {
        Lap car = lapRepository.findById(id).orElseThrow(); // TODO
        lapRepository.delete(car);
    }

}
