package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.springframework.stereotype.Service;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class FindFilm {
    private FilmRepository filmRepository;

    public FindFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    public Film execute(Long id) {
        return filmRepository.findOne(id);
    }
}
