package com.starwars.usecase.person;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class SavePerson {
    private PeopleRepository peopleRepository;

    public SavePerson(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public People execute(@NonNull People people) {
        return peopleRepository.save(people);
    }
}
