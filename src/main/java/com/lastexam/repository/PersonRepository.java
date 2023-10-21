package com.lastexam.repository;

import com.lastexam.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("SELECT p FROM Person p WHERE p.personId = " +
            "(SELECT c.person.personId FROM Command c " +
            " GROUP BY c.person.personId " +
            " ORDER BY COUNT(c.id) DESC " +
            " LIMIT 1)")
    Person findPersonWithMostCommands();
}
