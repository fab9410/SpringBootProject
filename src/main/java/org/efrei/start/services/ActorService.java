package org.efrei.start.services;

import org.efrei.start.models.Actor;
import org.efrei.start.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository repository;

    @Autowired
    public ActorService(ActorRepository repository) {
        this.repository = repository;
    }

    public List<Actor> findAll(){
        return repository.findAll();
    }

    public void create(Actor actor){
        //INSERT INTO actor VALUES (":firstname", ":lastname"
        repository.save(actor);

    }

    public Actor findById(String id) {
        // SELECT * FROM actor WHERE id = :id
        return repository.findById(id).orElse(null);    //FIND ID ou NULL
    }

    public void deleteById(String id) {
        //INSERT INTO actor VALUES (":firstname", ":lastname")
        repository.deleteById(id);
    }

    public void update(String id, Actor actor){
        Actor updateActor = findById(id);
        updateActor.setName(actor.getName());
        updateActor.setFirstname(actor.getFirstname());
        repository.save(updateActor);
        //UPDATE actor SET (firstname, name) VALUES (:firstname, :name) where id = :id;

    }
}
