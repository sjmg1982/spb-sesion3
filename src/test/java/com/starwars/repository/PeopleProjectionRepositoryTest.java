package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.PeopleWithNoPersonalInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleProjectionRepositoryTest {

    @Autowired
    private PeopleProjectionRepository peopleProjectionRepository;

    @Test
    public void should_find_no_personal() throws Exception {
        List<People> peopleList = peopleProjectionRepository.findAll();
        assertNotNull(peopleList);
    }
}
