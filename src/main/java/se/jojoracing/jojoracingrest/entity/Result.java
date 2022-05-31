package se.jojoracing.jojoracingrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Time startTime;
    private Time finishTime;

    @ManyToOne
    @JsonIgnore
    private Race race;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lap> laps = new ArrayList<>();

    public void createLaps(int laps) {
        for (int i = 1; i <= laps; i++) {
            this.laps.add(new Lap(i));
        }
    }

    public List<Lap> getLaps() {
        return laps.stream().sorted(Lap::compareTo).toList();
    }
}
