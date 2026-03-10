package com.example.movie.repository;

import com.example.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByDirectorContainingIgnoreCaseAndTitleContainingIgnoreCase(String director, String title);
    List<Movie> findByDirectorContainingIgnoreCase(String director);
    List<Movie> findByTitleContainingIgnoreCase(String title);
}