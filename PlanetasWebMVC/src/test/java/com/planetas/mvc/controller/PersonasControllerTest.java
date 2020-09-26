package com.planetas.mvc.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.planetas.mvc.models.Persona;
import com.planetas.mvc.services.PersonaService;


class PersonasControllerTest {
	
	@InjectMocks
	PersonasController personaController;
	
	@Mock 
	PersonaService personaService;
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testConsultarTodasPersonas() {
		
		List<Persona> personas =  new ArrayList<Persona>();
		List<Persona> personasTest =  new ArrayList<Persona>();
		personas = getListPersonas();
		
		when(personaService.getAllPersonas()).thenReturn(personas);
		
		personasTest = personaController.consultarTodasPersonas();
		assertNotNull(personasTest);
		assertEquals("Karen Molina",personasTest.get(2).getNombre());
	}

	@Test
	void testConsultarPersonaId() {
		
		try {
			Persona personaTest =new Persona();
			Persona persona =new Persona(1235,"Karen Molina",55,150,(float)19.5,"Femenino","1996/10/05",5,2,"Venus");
			
			Mockito.when(
					personaService.getPersonabyId(Mockito.anyInt())).thenReturn(persona);
			
			personaTest = personaController.consultarPersonaId(1235);
			
			assertNotNull(personaTest);
			assertEquals("Karen Molina", personaTest.getNombre());
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testTopPersonas() {
		try {
			List<Persona> personas =  new ArrayList<Persona>();
			List<Persona> personasTest =  new ArrayList<Persona>();
			personas = getListPersonas();
			
			when(personaService.getTopPersonas()).thenReturn(personas);
			
			personasTest = personaController.TopPersonas();
			assertNotNull(personasTest);
			assertEquals("Paola Garcia",personasTest.get(0).getNombre());
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	List<Persona> getListPersonas (){
			
			List<Persona> personas =  new ArrayList<Persona>();
			Persona persona = new Persona(123,"Paola Garcia",27,150,(float)12.5,"Femenino","1993/10/05",2,10,"Mercurio");
			Persona persona1 =new Persona(1234,"Camila Garcia",40,150,(float)70.5,"Femenino","1995/10/05",9,1,"Mercurio");
			Persona persona2 =new Persona(1235,"Karen Molina",55,150,(float)19.5,"Femenino","1996/10/05",5,8,"Venus");
			personas.add(persona);
			personas.add(persona1);
			personas.add(persona2);
			
			return personas;
		}

}
