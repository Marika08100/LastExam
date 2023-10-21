package com.lastexam.service;

import com.lastexam.model.Command;
import com.lastexam.model.Person;
import com.lastexam.repository.CommandRepository;
import com.lastexam.repository.PersonRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {
    private final PersonRepository personRepository;
    private final CommandRepository commandRepository;

    public EntityService(PersonRepository personRepository, CommandRepository commandRepository) {
        this.personRepository = personRepository;
        this.commandRepository = commandRepository;
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public List<Command> getAllCommand() {
        return commandRepository.findAll();
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<Command> getAllCommandsByPerson(Person person) {
        return commandRepository.getCommandByPerson(person);
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void saveCommand(Command command) {
        commandRepository.save(command);
    }

    public void deleteOrdersByPerson(Person person) {
        List<Command> orders = commandRepository.findByPerson(person);
        commandRepository.deleteAll(orders);
    }

    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Person updatedPerson) {
        if (updatedPerson.getPersonId() != null) {
            Person existingPerson = personRepository.findById(updatedPerson.getPersonId()).orElse(null);
            if (existingPerson != null) {
                existingPerson.setName(updatedPerson.getName());
                personRepository.save(existingPerson);
            }
        }
    }
    @Transactional
    public Person findPersonWithMostCommands() {
        return personRepository.findPersonWithMostCommands();
    }


}


