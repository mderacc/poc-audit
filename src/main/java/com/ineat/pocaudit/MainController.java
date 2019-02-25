package com.ineat.pocaudit;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.ineat.pocaudit.data.Movie;
import com.ineat.pocaudit.data.MovieRepository;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MainController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/movies")
	public List<Movie> retrieveAllMovies() {

		String result = "success"; // or something else
		Metrics.counter("message.sent", "result", result).increment();
		return movieRepository.findAll();
	}
}