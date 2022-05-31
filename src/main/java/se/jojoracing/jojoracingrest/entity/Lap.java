package se.jojoracing.jojoracingrest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Lap implements Comparable<Lap> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int lap;
    private Time lapTime;

    public Lap(int lap) {
        this.lap = lap;
    }


    @Override
    public int compareTo(Lap lap) {
        return (this.lap - lap.getLap());
    }
}
