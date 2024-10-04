package org.efrei.start.models;

import jakarta.persistence.*;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="firstname", nullable = false)
    private String firstname;

    public Actor(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
    }

    public Actor(){}

    public String getFirstname() {
        return firstname;
    }

    public String getName() {
        return name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
