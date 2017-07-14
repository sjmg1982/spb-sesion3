package com.starwars.usecase.person;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class FindPerson {
    private PeopleRepository peopleRepository;

    public FindPerson(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public People execute(@NonNull Long id) {
        return peopleRepository.findOne(id);
    }
}
