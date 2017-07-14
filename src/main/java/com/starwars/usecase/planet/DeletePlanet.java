package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class DeletePlanet {
    private PlanetRepository planetRepository;


    public DeletePlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(@NonNull Long id) {
        Planet found=planetRepository.findOne(id);
        planetRepository.delete(id);
        return found;
    }
}
