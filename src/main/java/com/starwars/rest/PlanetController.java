package com.starwars.rest;

import com.starwars.model.Planet;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjmg on 7/07/17.
 */
@RestController
@RequestMapping("/planets")
@AllArgsConstructor
public class PlanetController {

    private FindAllPlanets findAllPlanets;
    private FindPlanet findPlanet;
    private SavePlanet savePlanet;
    private DeletePlanet deletePlanet;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet>planets= findAllPlanets.execute();

        return new ResponseEntity<>(planets, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> save(@RequestBody Planet planet) {
        Planet updated= savePlanet.execute(planet);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT,path="/{id}")
    public ResponseEntity<Planet> update(@PathVariable Long id, Planet planet) {
        Planet found= findPlanet.execute(id);
        if(found==null) {
            return (ResponseEntity<Planet>) ResponseEntity.noContent();
        }
        Planet updated=savePlanet.execute(planet);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE,path="/{id}")
    public ResponseEntity<Planet> delete(@PathVariable Long id) {
        Planet deleted= deletePlanet.execute(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
