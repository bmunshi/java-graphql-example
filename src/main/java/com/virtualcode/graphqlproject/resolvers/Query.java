package com.virtualcode.graphqlproject.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtualcode.graphqlproject.models.SuperCharacter;
import com.virtualcode.graphqlproject.models.SuperGroup;
import com.virtualcode.graphqlproject.repos.SuperCharacterRepo;
import com.virtualcode.graphqlproject.repos.SuperGroupRepo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Query implements GraphQLQueryResolver {
    private SuperCharacterRepo superCharacterRepo;
    private SuperGroupRepo superGroupRepo;

    public Query(SuperCharacterRepo superCharacterRepo,SuperGroupRepo superGroupRepo) {
        this.superCharacterRepo = superCharacterRepo;
        this.superGroupRepo=superGroupRepo;
    }

    public List<SuperCharacter> characters(){
        return superCharacterRepo.getCharacters();
    }

    public SuperCharacter characterById(String id){
        return superCharacterRepo.getCharacterById(id);
    }

    public List<SuperGroup> groups(){
        return this.superGroupRepo.getTheGroups();
    }

    public SuperGroup groupByName(String name){
        return superGroupRepo.getSuperGroupByName(name);
    }

}
