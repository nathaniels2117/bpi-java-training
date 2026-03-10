package com.example.movie;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private LocalDate showingDate;

    public Movie() {}

    public Movie(Integer id,String title, String director, LocalDate showingDate) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.showingDate = showingDate;
    }

    
    public Integer getId() { 
    	return id; 
    }
    
    public void setId(Integer id) { 
    	this.id = id; 
    }

    public String getTitle() { 
    	return title; 
    }
    
    public void setTitle(String title) { 
    	this.title = title; 
    }
    
    public String getDirector() { 
    	return director; 
    }
    
    public void setDirector(String director) { 
    	this.director = director; 
    }

    public LocalDate getShowingDate() { 
    	return showingDate; 
    }
    
    public void setShowingDate(LocalDate showingDate) { 
    	this.showingDate = showingDate; 
    }

}