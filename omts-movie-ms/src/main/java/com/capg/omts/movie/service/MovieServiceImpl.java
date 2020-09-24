package com.capg.omts.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.omts.movie.Exception.MovieException;
import com.capg.omts.movie.model.Movie;
import com.capg.omts.movie.repository.MovieRepository;


@Service  //Indicates the annotated class is service
public class MovieServiceImpl implements MovieService 
{
	@Autowired //Enables to inject the object dependency implicitly
MovieRepository MovieRepo;
	
	@Override
     /** 
	  Adds the details of movie 
	 * 
	*/
	public Movie addMovie(Movie movie)  
	{
		Integer movieId =movie.getMovieId();
		if(!MovieRepo.existsById(movieId)) 
		
		{
		return MovieRepo.save(movie); //saves the details 
		}
		else
		{
			throw new MovieException("Movie Already added");// throws an exception if movie is already added 
		}
	}
	
	/**
	 *Updates the details of movie
	**/
	
	@Override
	public Movie updateMovie(Movie movie)  
	{
		Integer movieId = movie.getMovieId();
		if( MovieRepo.existsById(movieId))
		{ 

			return MovieRepo.save(movie) ;
		}
		throw new RuntimeException ("MovieNotFound"); //throws an exception if movie is not found
	}
	
	
	/* Deletes the movie by id
	 */
	
	@Override
	public Boolean deleteMovieById(int movieId)
	{
		if(MovieRepo.existsById(movieId)){
			MovieRepo.deleteById(movieId);
		}
		else {
			throw new MovieException("Movie Already Deleted or Movie Not Found"); //throws an exception if already deleted
			
		}
		return true;
	}

	
	/** 
	 *Returns the details of movie by movieId
	 */
	@Override
	public Movie getByMovieName(String movieName)
	{
		return MovieRepo.getByMovieName(movieName);
	}

	 /** Returns the movieId
	    */
	
	@Override
	public Movie getMovieById(int movieId)
	{
		
		return MovieRepo.getOne(movieId);
	}


	/* Returns the list of all movies
	 */

	@Override
	public List<Movie> findAllMovies()
	{
		
		return MovieRepo.findAll();
	}

	 //Validates movieId
	
	@Override
	public boolean validateMovieId(int movieId) 
	{
		String movie = Integer.toString(movieId);
		if (!(movie.length() >= 4)) {
		throw new MovieException("MovieId must be minimum of 4 characters"); //throws a movie exception
		}
		return true;

	}
}
