package com.movie.service;

import com.movie.dto.MovieDTO;

public interface MovieService {

	void addMovie(MovieDTO movieDTO);
	MovieDTO getMovie(Long Id);
}
