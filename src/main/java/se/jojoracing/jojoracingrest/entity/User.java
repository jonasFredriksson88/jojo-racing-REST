package se.jojoracing.jojoracingrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Time bestLap;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter(AccessLevel.NONE)
    @JsonIgnore
    private Set<Result> results;

    @ManyToOne
    private Car car;

    public void addCar(Car car) {
        this.car = car;
    }

    public void addRecord(Result result) {
        this.results.add(result);
        result.setUser(this);
    }

}
