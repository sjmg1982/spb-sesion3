package com.starwars.rest;

import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.usecase.person.DeletePerson;
import com.starwars.usecase.person.FindAllPeople;
import com.starwars.usecase.person.FindPerson;
import com.starwars.usecase.person.SavePerson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sjmg on 7/07/17.
 */
@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PeopleController {

    private FindAllPeople findAllPeople;
    private FindPerson findPerson;
    private SavePerson savePerson;
    private DeletePerson deletePerson;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<People>> findAll() {
        List<People>people= findAllPeople.execute();

        return new ResponseEntity<>(people, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<People> save(@RequestBody People people) {
        People updated= savePerson.execute(people);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT,path="/{id}")
    public ResponseEntity<People> update(@PathVariable Long id, People person) {
        People found= findPerson.execute(id);
        if(found==null) {
            return (ResponseEntity<People>) ResponseEntity.noContent();
        }
        People updated=savePerson.execute(person);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE,path="/{id}")
    public ResponseEntity<People> delete(@PathVariable Long id) {
        People deleted= deletePerson.execute(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
