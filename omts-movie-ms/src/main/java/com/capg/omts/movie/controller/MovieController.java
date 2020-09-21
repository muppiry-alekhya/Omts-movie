package com.capg.omts.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.omts.movie.Exception.MovieException;
import com.capg.omts.movie.model.Movie;
import com.capg.omts.movie.service.MovieServiceImpl;
/**
	* The MovieController is responsible for all Mapping to FrontEnd
	
**/

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieServiceImpl service;
	
	
	/** 
	 *This method is used to add the details of movie  
	 * 
	*/
	
	@PostMapping("/add")
	public Movie addMovie(@RequestBody Movie movie) 
	{
        //System.out.println("movie");
		int movieId = movie.getMovieId();
		if (service.validateMovieId(movieId))
		return service.addMovie(movie);
		return movie;
		
	}
	
	/**
	 * This method is used to update the details of movie
	**/
	@PutMapping("/update")
	public Movie updateMovie(@RequestBody Movie movie ) 
	{
	return service.updateMovie(movie);
    }
	
	
	/**
	 * 
	 * This method is used to delete the movie by id
	 */
	
	@DeleteMapping("/delete/id/{id}")
	public Boolean deleteMovieById(@PathVariable("id") int movieId) 
	{
	service.deleteMovieById(movieId);
	return true;
	}
	
	/** 
	 *This method is used to get the details of movie by movieId
	 */
	
	@GetMapping("/name/{movieName}")
	public Movie getByMovieName(@PathVariable String movieName) 
	
	{
	return service.getByMovieName(movieName);
	}

   /**
    * This method is used to get movieId
    */
	
	@GetMapping("get/id/{id}")
	public Movie getMovieById(@PathVariable("id") int movieId) 
    
    {
	
		return service.getMovieById(movieId);
	}

/**
 * 
 * This method is used to get the list of all movies
 */
	
	@GetMapping("/all")
	public List<Movie> findMovies()
	
	{
		return service.findAllMovies();
	}
	}
	
	
