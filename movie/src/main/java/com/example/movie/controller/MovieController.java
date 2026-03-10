package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO getMovieById(@PathVariable int id) {
        return movieService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO addMovie(@RequestBody MovieDTO dto) {
        return movieService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO updateMovie(@PathVariable int id, @RequestBody MovieDTO dto) {
        return movieService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteMovie(@PathVariable int id) {
        movieService.delete(id);

        Map<String, Object> body = new HashMap<>();
        body.put("message", "Movie deleted successfully");
        body.put("id", id);

        return ResponseEntity.ok(body);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> search(@RequestParam(required = false) String director,
                                 @RequestParam(required = false) String title) {
        return movieService.search(director, title);
    }
}
