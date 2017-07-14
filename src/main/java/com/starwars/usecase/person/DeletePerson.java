package com.starwars.usecase.person;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by sjmg on 7/07/17.
 */
@Service
public class DeletePerson {
    private PeopleRepository peopleRepository;

    public DeletePerson(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public People execute(@NonNull Long id) {
        People found=peopleRepository.findOne(id);
        peopleRepository.delete(id);
        return found;
    }
}
