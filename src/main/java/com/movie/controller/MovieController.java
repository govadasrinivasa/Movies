package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.MovieDTO;
import com.movie.service.impl.MovieServiceImpl;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieServiceImpl movieService;
	
	@PostMapping("/addmovie")
	public void addmovie(@RequestBody MovieDTO movieDTO) {
		movieService.addMovie(movieDTO);
	}
	
	@GetMapping("/selectmovie")
	public MovieDTO selectmovie(@PathVariable("Id") String Id, @PathVariable("moviename") String movieName) {
		MovieDTO movieDTO = movieService.selectMovie(Id, movieName);
		return movieDTO;
	}
	
}