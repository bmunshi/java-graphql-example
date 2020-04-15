package com.virtualcode.graphqlproject.repos;

import com.virtualcode.graphqlproject.models.SuperCharacter;
import com.virtualcode.graphqlproject.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperCharacterRepo{
    private SuperGroupRepo superGroupRepo;
    private List<SuperCharacter> theCharacters = new ArrayList<>();

    public SuperCharacterRepo(SuperGroupRepo superGroupRepo) {
        this.superGroupRepo = superGroupRepo;
        seedCharacter();

    }

    private void seedCharacter(){
        SuperCharacter c1 = new SuperCharacter("char1","Super character1",33);
        SuperCharacter c2 = new SuperCharacter("char2","Super character2",30);

        this.theCharacters.add(c1);
        this.theCharacters.add(c2);
    }
    public List<SuperCharacter> getCharacters() {
        return this.theCharacters;
    }


    public SuperCharacter getCharacterById(String id){
        List<SuperCharacter> superCharacters = this.theCharacters.stream().filter(ch->ch.getId().equalsIgnoreCase(id)).collect(Collectors.toList());
        if(superCharacters!=null && superCharacters.size()>0){
            return superCharacters.get(0);
        }else{
            return null;
        }
    }

    public SuperCharacter addCharacter(String name,Integer age,String groupName){
        SuperGroup sGroup = null;
        if(groupName!=null && !groupName.isEmpty()){
            sGroup = superGroupRepo.getSuperGroupByName(groupName);
        }
        SuperCharacter superCharacter = new SuperCharacter("char"+this.theCharacters.size()+1,name,age);
        superCharacter.setSuperGroup(sGroup);
        this.theCharacters.add(superCharacter);
        if(sGroup!=null)sGroup.addCharacter(superCharacter);
        return superCharacter;
    }
}