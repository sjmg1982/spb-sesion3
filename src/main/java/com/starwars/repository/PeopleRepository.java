package com.starwars.repository;

import com.starwars.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {
    People findByNameIgnoreCase(String name);
    List<People> findByHeightGreaterThanEqual(String height);
    List<People> findByEyeColorIn(Collection<String> eyeColors);
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameAsc(Collection<String> eyesColor);

    @Query(value = "select * from People where name like 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith();
}
