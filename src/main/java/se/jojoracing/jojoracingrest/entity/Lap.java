package se.jojoracing.jojoracingrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Lap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int lap;
    private long lapTime;

    public Lap() {

    }

    public Lap(int lap) {
        this.lap = lap;
    }
}
