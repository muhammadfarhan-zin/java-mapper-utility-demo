package com.example.javamapperutilitydemo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class PersonDto {
    @Getter
    @Setter
    @JsonProperty
    private String id;

    @Getter
    @Setter
    @JsonProperty
    private String name;

    public PersonDto() {
    }
    
    public PersonDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonDto(final Person person) {
        this.id = "demo-" + person.getId();
        this.name = person.getName();
    }

}
