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

import com.planetas.mvc.models.Persona;
import com.planetas.mvc.repositories.PersonaRepository;
import com.planetas.mvc.services.PersonaService;

class PersonaServiceTest {
	
	@InjectMocks
	PersonaService personaService;
	
	@Mock 
	PersonaRepository personaRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void testGetPersonabyId()  {
		try {
			Persona persona = new Persona();
			Persona personatest = new Persona();
			
			persona.setId_persona(123);
			persona.setNombre("Paola Garcia");
			persona.setEdad(27);
			persona.setAltuta(150);
			persona.setPeso((float)12.5);
			persona.setGenero("Femenino");
			persona.setFecha_nacimiento("1993/10/05");
			persona.setCantidad_visitas(0);
			persona.setId_planeta(1);
			persona.setNombre_planeta("Mercurio");
			
			Mockito.when(
					personaRepository.findById(Mockito.anyInt()).get()).thenReturn(persona);
			
			personatest = personaService.getPersonabyId(123);
			
			assertNotNull(personatest);
			assertEquals("Paola Garcia", personatest.getNombre());
		
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Test
	void testGetAllPersonas() {
		
		List<Persona> personas =  new ArrayList<Persona>();
		List<Persona> personasTest =  new ArrayList<Persona>();
		
		personas = getListPersonas();
		
		Mockito.when(
				personaRepository.findAll()).thenReturn(personas);
		
		personasTest = personaService.getAllPersonas();
		assertNotNull(personasTest);
		assertEquals("Karen Molina",personasTest.get(2).getNombre());
		
	}
	
	@Test
	void testGetTopPersonas() {
		List<Persona> personas =  new ArrayList<Persona>();
		List<Persona> personasTest =  new ArrayList<Persona>();
		
		personas = getListPersonas();
		
		Mockito.when(
				personaRepository.findAll()).thenReturn(personas);
		
		personasTest = personaService.getTopPersonas();
		assertNotNull(personasTest);
		assertEquals("Felipe Gomez",personasTest.get(0).getNombre());
	}
	
	List<Persona> getListPersonas (){
		
		List<Persona> personas =  new ArrayList<Persona>();
		
		Persona persona = new Persona(123,"Paola Garcia",27,150,(float)12.5,"Femenino","1993/10/05",0,1,"Mercurio");
		Persona persona1 =new Persona(1234,"Camila Garcia",40,150,(float)70.5,"Femenino","1995/10/05",0,1,"Mercurio");
		Persona persona2 =new Persona(1235,"Karen Molina",55,150,(float)19.5,"Femenino","1996/10/05",0,2,"Venus");
		Persona persona3 =new Persona(1236,"Alejandra Alarcon",66,150,(float)92.5,"Femenino","1957/10/05",1,2,"Venus");
		Persona persona4 =new Persona(1237,"Felipe Gomez",77,150,(float)52.5,"Masculino","1945/10/05",10,3,"Tierra");
		Persona persona5 =new Persona(1238,"Sofia Quintero",67,150,(float)16,"Femenino","1953/10/05",3,4,"Tierra");
		
		personas.add(persona);
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		personas.add(persona4);
		personas.add(persona5);
		
		return personas;
	}



}
