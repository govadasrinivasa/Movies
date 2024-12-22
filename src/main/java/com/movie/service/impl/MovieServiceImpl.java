package com.movie.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.movie.dto.MovieDTO;
import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepo;
	
    private ModelMapper mapper;
	
	public MovieServiceImpl(MovieRepository movieRepo, ModelMapper mapper) {
		this.movieRepo = movieRepo;
		this.mapper = mapper;
	}

	@Override
	public void addMovie(MovieDTO movieDTO) {
		if(movieDTO != null) {
			Movie movie = mapper.map(movieDTO, Movie.class);
			movieRepo.save(movie);
		}
	}

	@Override
	public MovieDTO getMovie(Long Id) {
		MovieDTO movieDTO = null;
		if(!Id.equals("") ) {
			Optional<Movie> movie = movieRepo.findById(Id);
			movieDTO = mapper.map(movie, MovieDTO.class);
		}
		return movieDTO;
	}

}
