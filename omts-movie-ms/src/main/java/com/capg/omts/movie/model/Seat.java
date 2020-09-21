package com.capg.omts.movie.model;


/**This class describe about all the Attributes that are used in Movie Module
 * All the setters and getters are created for Attributes
 * Also created constructor using Fields
 * And also created Generate to string...
 */

public class Seat {

	
	private int seatId;
	private Enum seatStatus;
	private double seatPrice;
	
	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Enum getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(Enum seatStatus) {
		this.seatStatus = seatStatus;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
}


