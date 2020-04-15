package com.virtualcode.graphqlproject.repos;

import com.virtualcode.graphqlproject.models.Orientation;
import com.virtualcode.graphqlproject.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperGroupRepo {
    private List<SuperGroup> theGroups = new ArrayList<>();

    public SuperGroupRepo() {
        seedGroup();
    }

    private void seedGroup(){
        SuperGroup g1 = new SuperGroup("grp1", Orientation.HERO);
        SuperGroup g2 = new SuperGroup("grp1", Orientation.HERO);

        this.theGroups.add(g1);
        this.theGroups.add(g2);
    }

    public List<SuperGroup> getTheGroups(){
        return this.theGroups;
    }

    public SuperGroup getSuperGroupByName(String name){
        List<SuperGroup> superGroups = this.theGroups.stream().filter(g->g.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        if(superGroups!=null && superGroups.size()>0){
            return superGroups.get(0);
        }else {
            return null;
        }
    }

    public SuperGroup addSuperGroup(String name,Orientation orientation){
        SuperGroup newGrp = new SuperGroup(name,orientation);
        this.theGroups.add(newGrp);
        return newGrp;
    }
}
