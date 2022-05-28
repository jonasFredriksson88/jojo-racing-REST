package se.jojoracing.jojoracingrest.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int laps;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Record> records = new HashSet<>();

    public void addRecord(Record record) {
        this.records.add(record);
    }
}
