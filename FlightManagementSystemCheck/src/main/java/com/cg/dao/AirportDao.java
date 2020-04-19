package com.cg.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Airport;

@Repository
@Transactional
public class AirportDao {


	@PersistenceContext
	EntityManager em;
	
	public String addAirport(Airport a)
	{
		em.persist(a);
		return "airport added successfuly";
	}
	
	public List<Airport> viewAirport()
	{
		Query query=em.createQuery("Select a from Airport a");
		return query.getResultList();
		
	}
	
	public Airport viewAirport(String airportCode)
	{
		List<Airport> list=viewAirport();
		Airport airport=null;
		Optional <Airport> optional=list.stream().
				filter(a1->a1.getAirportCode().equals(airportCode)).findFirst();
				if(optional.isPresent()) {
					airport=optional.get();
				}
		return airport;
		
	}
}
