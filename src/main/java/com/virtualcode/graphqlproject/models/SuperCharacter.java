package com.virtualcode.graphqlproject.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperCharacter{
    private String id;
    private String name;
    private Integer age;
    private SuperGroup superGroup;

    public SuperCharacter(String id, String name, Integer age, SuperGroup superGroup) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.superGroup = superGroup;
    }

    public SuperGroup getSuperGroup() {
        return superGroup;
    }

    public void setSuperGroup(SuperGroup superGroup) {
        this.superGroup = superGroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SuperCharacter() {
    }

    public SuperCharacter(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}