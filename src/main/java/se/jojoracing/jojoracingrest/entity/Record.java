package se.jojoracing.jojoracingrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Time startTime;
    private Time finishTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Lap> laps = new HashSet<>();

    public void addUser(User user) {
        this.user = user;
    }

    public void removeUser(User user) {
        this.user = null;
    }

    public void createLaps(int laps) {
        for (int i = 1; i <= laps; i++) {
            this.laps.add(new Lap(i));
        }
    }
}
