package com.starwars.repository;

import com.starwars.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long>, CustomFilmRepository{
    List<Film> findAllByOrderByEpisodeIdAsc();
    List<Film> findAllByReleaseDateGreaterThanEqual(Date releaseDate);

    @Query("select f from Film f where f.people.size = (select max(f2.people.size) from Film f2)")
    List<Film> fillAllByMaxPeople();

    @Query("select f from Film f where f.planets.size = (select min(f2.planets.size) from Film f2)")
    List<Film> fillAllByMinPlanets();

    @Query("select f from Film f join f.people p where p.name = :name")
    List<Film> findAllByPeopleContains(@Param("name") String name);
}
