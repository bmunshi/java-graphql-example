package com.virtualcode.graphqlproject;

import com.virtualcode.graphqlproject.repos.SuperCharacterRepo;
import com.virtualcode.graphqlproject.repos.SuperGroupRepo;
import com.virtualcode.graphqlproject.resolvers.Mutation;
import com.virtualcode.graphqlproject.resolvers.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlprojectApplication {

	@Autowired
	SuperCharacterRepo superCharacterRepo;

	@Autowired
	SuperGroupRepo superGroupRepo;

	@Bean
	public Query query(){return new Query(superCharacterRepo,superGroupRepo);};

	@Bean
	public Mutation mutation(){return new Mutation(superCharacterRepo,superGroupRepo);}
	public static void main(String[] args) {
		SpringApplication.run(GraphqlprojectApplication.class, args);
	}

}
