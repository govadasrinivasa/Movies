package com.movie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.movie.dto.MovieDTO;
import com.movie.repository.Movie;
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
	public MovieDTO selectMovie(String Id, String movieName) {
		MovieDTO movieDTO = null;
		if(!Id.equals("") && !movieName.equals("")) {
			Movie movie = movieRepo.findMovieByMoviename(Long.getLong(Id), movieName);
			movieDTO = mapper.map(movie, MovieDTO.class);
		}
		return movieDTO;
	}

}
