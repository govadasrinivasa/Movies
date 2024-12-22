package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

//	@Query("select m from movie where m.Id='Id' and m.moviename like '%moviename%'")
//    Movie findMovieByMoviename(@Param("Id") Long Id, @Param("moviename") String moviename);
}
