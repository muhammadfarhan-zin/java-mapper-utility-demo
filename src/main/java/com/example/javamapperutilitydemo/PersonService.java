package com.example.javamapperutilitydemo;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> getPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(person -> {
            PersonDto personDto = MapperUtil.map(person, PersonDto.class);
            return personDto;
        }).collect(Collectors.toList());
    }

    public PersonDto addPerson(PersonDto personDto) {
        Person person = MapperUtil.map(personDto, Person.class);
        person = personRepository.save(person);
        return MapperUtil.map(person, PersonDto.class);
    }
}

