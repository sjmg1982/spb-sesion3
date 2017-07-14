package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.repository.FilmRepository;
import com.starwars.repository.PeopleRepository;
import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class SaveFilm {
    private FilmRepository filmRepository;
    private PeopleRepository peopleRepository;
    private PlanetRepository planetRepository;

    public SaveFilm(FilmRepository filmRepository, PeopleRepository peopleRepository, PlanetRepository planetRepository) {
        this.filmRepository = filmRepository;
        this.peopleRepository = peopleRepository;
        this.planetRepository = planetRepository;
    }

    public Film execute(@NonNull Film film){
        film.getPlanets().forEach((Planet planet)-> {
            if(!planetRepository.exists(planet.getPlanetId())) {
                planetRepository.save(planet);
            }
        });
        film.getPeople().forEach((People people)-> {
            if(!peopleRepository.exists(people.getPeopleId())) {
                peopleRepository.save(people);
            }
        });
        return filmRepository.save(film);
    }
}
