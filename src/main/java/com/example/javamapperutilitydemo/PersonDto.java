package com.example.javamapperutilitydemo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class PersonDto {
    @JsonProperty
    private String id;

    @Getter
    @Setter
    @JsonProperty
    private String name;

    public PersonDto() {
    }

    public String getId() {
        return "demo-" + this.id;
    }

    @JsonIgnore
    public String getShortId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id.replace("demo-", "");
    }
}
