package com.planetas.mvc.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetas.mvc.models.Persona;
import com.planetas.mvc.models.Planeta;
import com.planetas.mvc.repositories.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	@Autowired 
	private PlanetaService planetaService;


	public List<Persona> getAllPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		personaRepository.findAll().forEach(persona -> personas.add(persona));
		
		return personas;
	}

	public Persona getPersonabyId (int id) {
		
		return personaRepository.findById(id).get();
	}

	public void saveorUpdate(int id_persona) {
		
		Persona persona = new Persona();
		Planeta planeta = new Planeta();
		
		// aumentar contador personas
		persona = getPersonabyId(id_persona);
		persona.setCantidad_visitas(persona.getCantidad_visitas()+1);
		
		// conocer planeta
		planeta = planetaService.getPlanetabyId(persona.getId_planeta());
		
		//actualizar planeta y persona
		planetaService.saveorUpdate(planeta.getId_planeta());
		personaRepository.save(persona);
	}
	
	public List<Persona> getTopPersonas(){
		int i=0;
		List<Persona> personas = new ArrayList<Persona>();
		List<Persona> personasTop = new ArrayList<Persona>();
		personaRepository.findAll().forEach(persona -> personas.add(persona));
		personas.sort(Comparator.comparing(Persona::getCantidad_visitas).reversed());
		
		for (Persona persona2 : personas) {
			if (i < 3) {
				personasTop.add(persona2);
			}
			i++;
		}
		return personasTop;
	}
	
	public void inicializarPersonas() {
		personaRepository.save(new Persona(123,"Paola Garcia",27,150,(float)12.5,"Femenino","1993/10/05",0,1,"Mercurio"));
		personaRepository.save(new Persona(1234,"Camila Garcia",40,150,(float)70.5,"Femenino","1995/10/05",0,1,"Mercurio"));
		personaRepository.save(new Persona(1235,"Karen Molina",55,150,(float)19.5,"Femenino","1996/10/05",0,2,"Venus"));
		personaRepository.save(new Persona(1236,"Alejandra Alarcon",66,150,(float)92.5,"Femenino","1957/10/05",0,2,"Venus"));
		personaRepository.save(new Persona(1237,"Felipe Gomez",77,150,(float)52.5,"Masculino","1945/10/05",0,3,"Tierra"));
		personaRepository.save(new Persona(1238,"Sofia Quintero",67,150,(float)16,"Femenino","1953/10/05",0,4,"Tierra"));
		personaRepository.save(new Persona(1239,"Falcao Hernandez",12,150,(float)73.5,"Masculino","2008/10/05",0,4,"Marte"));
		personaRepository.save(new Persona(12310,"Guillermo Ortiz",23,150,(float)44.5,"Masculino","1997/10/05",0,3,"Tierra"));
		personaRepository.save(new Persona(12311,"Maria Ospina",25,150,(float)65,"Femenino","1995/10/05",0,5,"Jupiter"));
		personaRepository.save(new Persona(12312,"Juan Sanchez",28,150,(float)65,"Masculino","1992/10/05",0,5,"Jupiter"));
	}
	
}
