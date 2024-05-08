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
        return persons.stream().map(person -> MapperUtil.map(person, PersonDto.class)).collect(Collectors.toList());
    }


    public PersonDto getPerson(int id) {
        Person person = personRepository.findById(id);
        return MapperUtil.map(person, PersonDto.class);

    }

    public PersonDto addPerson(PersonDto personDto) {
        personDto.setId(personDto.getShortId());
           Person person = MapperUtil.map(personDto, Person.class);
            personRepository.save(person);
            return personDto;
    }
}

