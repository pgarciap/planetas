package com.planetas.mvc.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.planetas.mvc.models.Planeta;
import com.planetas.mvc.repositories.PlanetaRepository;
import com.planetas.mvc.services.PlanetaService;

class PlanetaServiceTest {

	@InjectMocks
	PlanetaService planetaService;
	
	@Mock 
	PlanetaRepository planetaRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllPlanetas() {
		List <Planeta> planetas = new ArrayList<Planeta>();
		List <Planeta> planetasTest = new ArrayList<Planeta>();
		
		planetas = getListPlanetas();
		
		Mockito.when(
				planetaRepository.findAll()).thenReturn(planetas);
		
		planetasTest = planetaService.getAllPlanetas();
		assertNotNull(planetasTest);
		assertEquals("Tierra",planetasTest.get(2).getNombre());
		
	}

	@Test
	void testGetPlanetabyId() {

		try {
			Planeta planetaTest = new Planeta();
			Planeta planeta = new Planeta(1,"Mercurio","58d 15h 30m","Caliente","Rocoso",2,0);
			
			Mockito.when(
					planetaRepository.findById(Mockito.anyInt()).get()).thenReturn(planeta);
			planetaTest = planetaService.getPlanetabyId(1);
			
			assertNotNull(planetaTest);
			assertEquals("Mercurio",planetaTest.getNombre());
			
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Test
	void testGetTopPlanetas() {
		List <Planeta> planetas = new ArrayList<Planeta>();
		List <Planeta> planetasTest = new ArrayList<Planeta>();
		
		planetas = getListPlanetas();
		
		Mockito.when(
				planetaRepository.findAll()).thenReturn(planetas);
		
		planetasTest = planetaService.getTopPlanetas();
		assertNotNull(planetasTest);
		assertEquals("Tierra",planetasTest.get(0).getNombre());
	}
	
	List<Planeta> getListPlanetas (){
		
		List <Planeta> planetas = new ArrayList<Planeta>();
		
		Planeta planeta = new Planeta(1,"Mercurio","58d 15h 30m","Caliente","Rocoso",2,0);
		Planeta planeta1 = new Planeta(2,"Venus","116d 18h 0m","Caliente","Rocoso",2,0);
		Planeta planeta2 = new Planeta(3,"Tierra","0d 24h 0m","Calido","Rocoso",3,8);
		Planeta planeta3 = new Planeta(4,"Marte","1d 0h 37m","Frio","Rocoso",1,3);
		Planeta planeta4 = new Planeta(5,"Jupiter","0d 9h 56m","Frio","Rocoso",2,5);
		
		planetas.add(planeta);
		planetas.add(planeta1);
		planetas.add(planeta2);
		planetas.add(planeta3);
		planetas.add(planeta4);
		
		return planetas;
		
	}

}
