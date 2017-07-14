package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.PeopleWithNoPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource(excerptProjection=PeopleWithNoPersonalInfo.class)
public interface PeopleProjectionRepository extends JpaRepository<People,Long> {

    List<People> findAll();
}
