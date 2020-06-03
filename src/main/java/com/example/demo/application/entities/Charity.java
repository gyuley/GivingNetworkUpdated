package com.example.demo.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final String description;
    private final String budget;
    private final String author;
    private int author_id;

    public Charity(String author) {
        this.author = author;
        this.name = "";
        this.description = "";
        this.budget = "";
    }

    public Charity(String name, String desc, String budget, String author) {
        this.name = name;
        this.description = desc;
        this.budget = budget;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAuthor_id() {return author_id;}

    @Override
    public String toString() {
        return "Charity{" + "id=" + id + ", name=" + name + ", budget=" + budget + '}';
    }
}