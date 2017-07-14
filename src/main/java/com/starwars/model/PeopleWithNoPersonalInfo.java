package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by sjmg on 14/07/17.
 */
@Projection(name="peopleWithNoPersonalInfo",types = People.class)
public interface PeopleWithNoPersonalInfo {
    String getName();
    String getBirthYear();
}
