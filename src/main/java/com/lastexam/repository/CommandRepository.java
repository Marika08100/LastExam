package com.lastexam.repository;

import com.lastexam.model.Command;
import com.lastexam.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command,Integer> {

    List<Command> getCommandByPerson(Person person);

    List<Command> findByPerson(Person person);
}
