package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by sjmg on 14/07/17.
 */
@Projection(name="filmsTitleWithOpening",types = Film.class)
public interface FilmsTitleWithOpening {

}
