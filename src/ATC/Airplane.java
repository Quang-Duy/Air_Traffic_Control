package ATC;

/**
 * Models an airplane 
 * @author Quang-Duy Tran
 *
 */

import java.util.Random;

public class Airplane {
	
	public static Integer MAGIC_NUMBER = 15000; //The given magic number to calculate approach code
	
	private String flight_number;
	private int distance;
	private int elevation;
	private int approach_code;
	
	/**
	 * Default constructor
	 * Creates a new random flight number
	 * Random generate a distance from 3000 to 20,000 meters
	 * Random generate a elevation from 1000 to 3000 meters
	 */
	public Airplane()
	{
		Random rnd = new Random();

		//Random generate two-character airline designator
		this.flight_number = (char)(rnd.nextInt(26) + 'A') + "";
		this.flight_number += (char)(rnd.nextInt(26) + 'A') + " ";
		
		//Random generate a 2- to 3-digit number 
		this.flight_number += rnd.nextInt(990) + 10;
		
		distance = rnd.nextInt(19701) + 3000;
		
		elevation = rnd.nextInt(2001) + 1000;
		
		approach_code = approach_code_calculating();
	}
	
	/**
	 * Let user input a flight number
	 * Set the flight_number to variable flight_number
	 * @param flight_number the given flight number from user
	 */
	public Airplane(String flight_number)
	{
		Random rnd = new Random();
		
		this.flight_number = flight_number;
		distance = rnd.nextInt(19701) + 3000;
		elevation = rnd.nextInt(2001) + 1000;
		
		approach_code = approach_code_calculating();
	}
	
	/**
	 * Copy constructor; Deep copy another object to this object
	 * @param other the other object
	 */
	public Airplane(Airplane other)
	{
		this.approach_code = other.approach_code;
		this.distance = other.distance;
		this.elevation = other.elevation;
		this.flight_number = other.flight_number;
	}
	
	/**
	 * Helper function; Calculating the approach code
	 * @return the approach code
	 */
	public int approach_code_calculating()
	{
		return MAGIC_NUMBER - (this.distance + this.elevation)/2;
	}
	
				/****** Getter functions ******/
	public String getFlightNumber() { return this.flight_number; }
	
	public int getDistance() { return this.distance; }
	
	public int getElevation() { return this.elevation; }
	
	public int getApproachCode() { return this.approach_code; }
	
				/****** Setter function ******/
	public void setApproachCode(int approach_code) { this.approach_code = approach_code; }
}
