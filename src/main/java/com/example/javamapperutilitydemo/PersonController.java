package com.example.javamapperutilitydemo;


import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDto> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public PersonDto addPerson(@RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }
}
