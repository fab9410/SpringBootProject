package org.efrei.start.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;


    @OneToOne
    private Actor actor;


    public Movie(String title){
        this.title = title;
    }

    public Movie() {}

    public String getMovieName(){
        return title;
    }

    public String getId(){
        return id;
    }

    public void setMovieTitle(String title){
        this.title = title;
    }

    public void setId(String id){
        this.id = id;
    }

}
