package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AirportDao;

import com.cg.dao.FlightDao;
import com.cg.entity.Airport;
import com.cg.entity.Flight;

@Service
public class FMSservice {
	
	@Autowired
	private FlightDao flightDaoImpl;
	

	@Autowired
	private AirportDao airportDaoImpl;

	
	//Flight
		public List<Flight> viewFlight(){
			return flightDaoImpl.viewFlight();
		}
		
		public Flight viewFlight(int flightNumber) {
			return flightDaoImpl.viewFlight(flightNumber);
		}
		
		public String addFlight(Flight flight) {
			return flightDaoImpl.addFlight(flight);
		}
		
		public String deleteFlight(int flightNumber) {
			return flightDaoImpl.deleteFlight(flightNumber);
		}
		
		public String modifyFlight(Flight flight) {
			return flightDaoImpl.modifyFlight(flight);
		}
		
		//Airport
		
		public String addAirport(Airport a) {
			return airportDaoImpl.addAirport(a);
		}
		
		public List<Airport> viewAirport(){
			return airportDaoImpl.viewAirport();
		}
		
		public Airport viewAirport(String airportCode) {
			return airportDaoImpl.viewAirport(airportCode);
		}	
}
