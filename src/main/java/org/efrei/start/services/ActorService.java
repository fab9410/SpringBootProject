package org.efrei.start.services;

import org.efrei.start.dto.CreateActor;
import org.efrei.start.dto.CreateMovie;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository repository;

    private final MovieService movieService;

    @Autowired
    public ActorService(ActorRepository repository,MovieService movieService){
        this.repository = repository;
        this.movieService = movieService;
    }

    public List<Actor> findAll(){
        return (List<Actor>) repository.findAll();
    }

    public void create(CreateActor createActor){
        Actor actor = new Actor();
        Movie movie = movieService.findById(createActor.getMovieId());
        actor.setName(createActor.getName());
        actor.setFirstname(createActor.getFirstname());
        actor.setMovie(movie);
        repository.save(actor) ;
    }
    public Actor findById(String id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public void updateActor(String id, Actor actor){
        Actor updateActor = findById(id);
        updateActor.setName((actor.getName()));
        updateActor.setFirstname(actor.getFirstname());
        repository.save(updateActor);
    }
}
