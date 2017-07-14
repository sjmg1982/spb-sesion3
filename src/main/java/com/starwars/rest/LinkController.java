package com.starwars.rest;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


/**
 * Created by sjmg on 7/07/17.
 */
@Controller
@RequestMapping(path = "/links")
@AllArgsConstructor
public class LinkController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResourceSupport> allLinks() {
        Link swapiLink=new Link("http://swapi.co");
        Link planetLink=linkTo(PlanetController.class).withRel("planets");

        ResourceSupport resunt = new ResourceSupport();
        resunt.add(swapiLink);
        resunt.add(planetLink);

        return new ResponseEntity<ResourceSupport>(resunt, HttpStatus.OK);
    }
}
