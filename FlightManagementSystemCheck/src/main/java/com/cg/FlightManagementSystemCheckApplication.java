package com.cg;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.AirportDao;
import com.cg.dao.FlightDao;
import com.cg.entity.Airport;
import com.cg.entity.Flight;

@SpringBootApplication
public class FlightManagementSystemCheckApplication implements CommandLineRunner{

	@Autowired
	FlightDao fdao;
	
	@Autowired
	AirportDao adao;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemCheckApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//Flight
		Flight f1=new Flight(100,"J44","Air India",100);
		Flight f2=new Flight(101,"I56","Indigo",80);
		
		fdao.addFlight(f1);
		fdao.addFlight(f2);
		
		System.out.println("Flight Record Inserted");
		
		List <Flight> flist=fdao.viewFlight();
		
		for(Flight f:flist)
		{
			System.out.println(f.toString());
		}
		
		//Airport
		Airport a1=new Airport("A1","IGI AIrport","Delhi");
		Airport a2=new Airport("B1","VTZ AIrport","Vishaapatanam");
		
		adao.addAirport(a1);
		adao.addAirport(a2);
		
		System.out.println("Airport Record Inserted");
		
		List <Airport> alist=adao.viewAirport();
		
		for(Airport a:alist)
		{
			System.out.println(a.toString());
		}
		
	}

}
