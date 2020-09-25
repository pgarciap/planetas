package com.planetas.mvc.services;

import java.util.ArrayList;
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
		
		// aumentar contador planeta
		planeta = planetaService.getPlanetabyId(persona.getId_planeta());
		planeta.setCantidad_vistas(planeta.getCantidad_vistas()+1);
		
		//actualizar planeta y persona
		planetaService.saveorUpdate(planeta.getId_planeta());
		personaRepository.save(persona);
	}
	
	
	
	
}
