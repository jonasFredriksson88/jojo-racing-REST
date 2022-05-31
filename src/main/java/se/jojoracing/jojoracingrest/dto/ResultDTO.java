package se.jojoracing.jojoracingrest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Time;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResultDTO(Time startTime, Time finishTime, UserDTO user, List<LapDTO> laps) {
}
