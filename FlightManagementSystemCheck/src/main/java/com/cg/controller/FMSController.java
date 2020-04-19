package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Airport;
import com.cg.entity.Flight;
import com.cg.service.FMSservice;

@Component
@RestController
public class FMSController {

	@Autowired
	FMSservice fmsService;
	
	//Flight
	
	@GetMapping("/flight")
	public List<Flight> viewFlight()
	{
		return fmsService.viewFlight();
	}
	
	@GetMapping(value="/flight/{flightid}",produces= {"application/json"})
	public Flight viewFlight(int flightNumber) {
		return fmsService.viewFlight(flightNumber);
	}
	
	@PostMapping(value="/flight/add",consumes={"application/json"})
	public String addFlight(Flight flight){
		return fmsService.addFlight(flight);
	}

	@DeleteMapping("/flight/delete/{flightid}")
	public String deleteFlight(int flightNumber){
		return fmsService.deleteFlight(flightNumber);
	}
	
	@PutMapping(value="/flight/modify",consumes= {"application/json"})
	public String modifyFlight(Flight flight){
		return fmsService.modifyFlight(flight);
	}
	
	
	//Airport
	
		@GetMapping(value="/airport/add",consumes= {"application/json"})
		public String addAirport(Airport airport) {
			return fmsService.addAirport(airport);
			
		}
	
		@GetMapping(value="/airport")
		public List<Airport> viewAirport(){
			return fmsService.viewAirport();
		}
		
		@GetMapping(value="/airport/{airportCode}")
		public Airport viewAirport(String airportCode) {
			return fmsService.viewAirport(airportCode);
		}
		
}
