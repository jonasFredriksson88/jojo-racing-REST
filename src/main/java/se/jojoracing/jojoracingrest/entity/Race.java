package se.jojoracing.jojoracingrest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany
    private Set<Lap> laps = new HashSet<>();

    @ManyToMany
    private Set<User> users = new HashSet<>();

}
