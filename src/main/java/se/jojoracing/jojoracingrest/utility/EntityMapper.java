package se.jojoracing.jojoracingrest.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import se.jojoracing.jojoracingrest.dto.*;
import se.jojoracing.jojoracingrest.entity.*;

import java.util.List;

public class EntityMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static LapDTO lapToDTO(Lap lap) {
        return mapper.convertValue(lap, LapDTO.class);
    }

    public static List<LapDTO> lapToDTO(List<Lap> laps) {
        return laps.stream().map(lap -> lapToDTO(lap)).toList();
    }

    public static Race raceToEntity(RaceDTO race) {
        return mapper.convertValue(race, Race.class);
    }

    public static RaceDTO raceToDTO(Race race) {
        return mapper.convertValue(race, RaceDTO.class);
    }

    public static List<RaceDTO> raceToDTO(List<Race> races) {
        return races.stream().map(race -> raceToDTO(race)).toList();
    }

    public static ResultDTO resultToDTO(Result result) {
        return mapper.convertValue(result, ResultDTO.class);
    }

    public static List<ResultDTO> resultToDTO(List<Result> results) {
        return results.stream().map(result -> resultToDTO(result)).toList();
    }

    public static User userToEntity(UserDTO user) {
        return mapper.convertValue(user, User.class);
    }

    public static UserDTO userToDTO(User user) {
        return mapper.convertValue(user, UserDTO.class);
    }

    public static List<UserDTO> userToDTO(List<User> users) {
        return users.stream().map(user -> userToDTO(user)).toList();
    }

    public static Car carToEntity(CarDTO car) {
        return mapper.convertValue(car, Car.class);
    }

    public static CarDTO carToDTO(Car car) {
        return mapper.convertValue(car, CarDTO.class);
    }

    public static List<CarDTO> carToDTO(List<Car> cars) {
        return cars.stream().map(car -> carToDTO(car)).toList();
    }
}
