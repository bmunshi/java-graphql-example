package com.virtualcode.graphqlproject.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Builder
public class SuperGroup {
    private String name;
    private Orientation orientation;
    private List<SuperCharacter> members;

    public SuperGroup() {
    }

    public SuperGroup(String name, Orientation orientation, List<SuperCharacter> members) {
        this.name = name;
        this.orientation = orientation;
        this.members = members;
    }

    public SuperGroup(String name, Orientation orientation) {
        this.name = name;
        this.orientation = orientation;
    }

    public void addCharacter(SuperCharacter superCharacter){
        if(members==null){
            members=new ArrayList<>();
        }
        if(superCharacter!=null)members.add(superCharacter);
    }

    public void removeCharacter(SuperCharacter superCharacter){
        this.members = this.members.stream().filter(ch->!ch.getName().equalsIgnoreCase(superCharacter.getName())).collect(Collectors.toList());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public List<SuperCharacter> getMembers() {
        return members;
    }

    public void setMembers(List<SuperCharacter> members) {
        this.members = members;
    }
}
