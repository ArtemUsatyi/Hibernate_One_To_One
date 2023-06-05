package ru.springCrud.model;

import javax.persistence.*;

@Entity
@Table(name = "School")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_school")
    private String name;

    @OneToOne
    @JoinColumn(name = "id_director", referencedColumnName = "id")
    private Director director;

    public School() {
    }

    public School(String name, Director director) {
        this.name = name;
        this.director=director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
