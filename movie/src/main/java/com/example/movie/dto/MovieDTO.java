package com.example.movie.dto;

import com.example.movie.Movie;
import java.time.LocalDate;

public class MovieDTO {

    private Integer id;
    private String title;
    private String director;
    private LocalDate showingDate;

    public MovieDTO() {}

    public MovieDTO(Integer id, String title, String director, LocalDate showingDate) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.showingDate = showingDate;
    }

    public static MovieDTO from(Movie m) {
        return new MovieDTO(
                m.getId(),
                m.getTitle(),
                m.getDirector(),
                m.getShowingDate()
        );
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