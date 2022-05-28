package se.jojoracing.jojoracingrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Time bestLap;

    @ManyToOne
    private Car car;

    public void addCar(Car car) {
        this.car = car;
    }
}
