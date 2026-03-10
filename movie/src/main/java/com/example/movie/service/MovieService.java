package com.example.movie.service;

import com.example.movie.Movie;
import com.example.movie.dto.MovieDTO;
import com.example.movie.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public List<MovieDTO> getAll() {
        return repo.findAll().stream().map(MovieDTO::from).toList();
    }

    public MovieDTO getById(int id) {
        Movie m = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        return MovieDTO.from(m);
    }

    public MovieDTO create(MovieDTO dto) {
        // Basic null checks (pwede mo palawigin gamit Bean Validation sa entity/DTO)
        if (dto.getTitle() == null || dto.getTitle().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title is required");
        }
        if (dto.getDirector() == null || dto.getDirector().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Director is required");
        }
        if (dto.getShowingDate() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Showing date is required");
        }

        Movie saved = repo.save(new Movie(
                null,
                dto.getTitle(),
                dto.getDirector(),
                dto.getShowingDate()
        ));
        return MovieDTO.from(saved);
    }

    public MovieDTO update(int id, MovieDTO dto) {
        Movie m = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));

        if (dto.getTitle() != null)       m.setTitle(dto.getTitle());
        if (dto.getDirector() != null)    m.setDirector(dto.getDirector());
        if (dto.getShowingDate() != null) m.setShowingDate(dto.getShowingDate());

        return MovieDTO.from(repo.save(m));
    }

    public void delete(int id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }
        repo.deleteById(id);
    }

    public List<MovieDTO> search(String director, String title) {
        boolean hasDirector = director != null && !director.isBlank();
        boolean hasTitle    = title    != null && !title.isBlank();

        if (hasDirector && hasTitle) {
            return repo.findByDirectorContainingIgnoreCaseAndTitleContainingIgnoreCase(director, title)
                       .stream().map(MovieDTO::from).toList();
        } else if (hasDirector) {
            return repo.findByDirectorContainingIgnoreCase(director)
                       .stream().map(MovieDTO::from).toList();
        } else if (hasTitle) {
            return repo.findByTitleContainingIgnoreCase(title)
                       .stream().map(MovieDTO::from).toList();
        } else {
            return getAll();
        }
    }
}