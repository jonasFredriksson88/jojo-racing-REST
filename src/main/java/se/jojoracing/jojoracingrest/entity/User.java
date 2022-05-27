package se.jojoracing.jojoracingrest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<>();

    @ManyToMany
    private Set<Race> races = new HashSet<>();

}
