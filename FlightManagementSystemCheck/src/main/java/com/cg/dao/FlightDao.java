package com.cg.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Flight;

@Repository
@Transactional
public class FlightDao {
	@PersistenceContext
	EntityManager em;
	
	//view all flights
	public List<Flight> viewFlight()
	{
		Query query=em.createQuery("select f from Flight f");
		return query.getResultList();
	}

	//view specific flight
	public Flight viewFlight(int flightNumber)
	{
		List <Flight> list=viewFlight();
		Flight f=null;
		Optional <Flight> optional=list.stream().
				filter(f1->f1.getFlightNumber()==flightNumber).findFirst();
		if(optional.isPresent()) {
			f=optional.get();
		}
		return f;
		
	}
	
	//adding new flight
	public String addFlight(Flight f)
	{
		em.persist(f);
		return "flight added successfully";
	}
	
	//removing unwanted flight
	public String deleteFlight(int flightNumber) {
		em.remove(viewFlight(flightNumber));
		return "Flight deleted successfully";
	}
	
	//modify flight details
	public String modifyFlight(Flight f) {
		em.merge(f);
		return "Flight updated successfully";
	}
	

}
