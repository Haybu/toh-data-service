package io.agilehandy.heroes;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hxm3459 on 10/29/16.
 */
@Data
@Entity
public class Hero {

    @Id
    @GeneratedValue
    Long id;

    String name;

    public Hero() {} // why

    public Hero(String nm) {
        this.name = nm;
    }
}
