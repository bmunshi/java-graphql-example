package com.virtualcode.graphqlproject.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtualcode.graphqlproject.models.Orientation;
import com.virtualcode.graphqlproject.models.SuperCharacter;
import com.virtualcode.graphqlproject.models.SuperGroup;
import com.virtualcode.graphqlproject.repos.SuperCharacterRepo;
import com.virtualcode.graphqlproject.repos.SuperGroupRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mutation implements GraphQLMutationResolver {
    private SuperCharacterRepo superCharacterRepo;
    private SuperGroupRepo superGroupRepo;

    public Mutation(SuperCharacterRepo superCharacterRepo,SuperGroupRepo superGroupRepo) {
        this.superCharacterRepo = superCharacterRepo;
        this.superGroupRepo=superGroupRepo;
    }


    public SuperCharacter addCharacter(String name, Integer age,String groupName){
        return superCharacterRepo.addCharacter(name,age,groupName);
    }

    public SuperGroup addGroup(String name, Orientation orientation){
        return superGroupRepo.addSuperGroup(name,orientation);
    }
}
