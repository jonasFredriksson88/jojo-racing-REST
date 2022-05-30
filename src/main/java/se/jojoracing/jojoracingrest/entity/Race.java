package se.jojoracing.jojoracingrest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int laps;

    @OneToMany(mappedBy = "race",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Result> results = new HashSet<>();

    public void addRecord(Result result) {
        this.results.add(result);
        result.setRace(this);
    }

}
