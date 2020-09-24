package com.cap.Omts.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.cap.Omts.*;
import com.cap.Omts.controller.*;
import com.capg.omts.movie.OmtsMovieMsApplication;
import com.capg.omts.movie.model.Movie;
import com.capg.omts.movie.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =OmtsMovieMsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(locations= {"classpath*:/spring/test-content.xml"})

public class OmtsMovieMsApplicationTestsService
{
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    MovieServiceImpl service;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    @Test
    public void contextLoads() {

    }
    
   
    @Test
    public void testByMovieName()
    {
    	//String movieName="Bahubali";
    	Movie movie=service.getByMovieName("Bahubali");
    	assertNotNull(movie); 	
    }
    
    @Test
    public void testByMovieId()
    
    {
    	int movieId=3415;
    	Movie movie=service.getMovieById(movieId);
    	assertNotNull(movie); 	
    }
    
   
    @Test
    public void testfindMovies()
    {
    	List<Movie> movie=service.findAllMovies();
    	assertNotNull(movie);
    	
    	
    }
    @Test
    public void testdeleteMovieById()
    {
    	int movieId=3415;
    	boolean movie=service.deleteMovieById(movieId);
    	assertNotNull(movie);
    }
   
    
    
    
    
    /*Test
    public void testGetDetails()
    {
    	
    	List<Booking> booking=bookingservice.getDetails();
    	
    	assertNotNull(booking);
    	
    }
    
    
    @Test
    public void testdeleteBookingById()
    {
    	int bookingId=1;
    	boolean booking=bookingservice.deletebookingbyId(bookingId);
    	assertNotNull(booking);
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
}