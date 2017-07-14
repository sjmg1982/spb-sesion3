package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.repository.FilmRepository;
import com.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class FindAllFilms {
    private FilmRepository filmRepository;

    public FindAllFilms(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    public List<Film> execute() {
        return filmRepository.findAll();
    }
}
