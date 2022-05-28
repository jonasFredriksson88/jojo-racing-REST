package se.jojoracing.jojoracingrest.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    @Column(unique = true)
    private String imgUrl;

    public Car() {

    }

}
