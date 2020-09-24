package com.planetas.mvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetas.mvc.models.Persona;
import com.planetas.mvc.repositories.PersonaRepository;



@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	public List<Persona> getAllPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		personaRepository.findAll().forEach(persona -> personas.add(persona));
		
		return personas;
	}

	public Persona getPersonabyId (int id) {
		
		return personaRepository.findById(id).get();
	}

	public void saveorUpdate(Persona persona) {
		personaRepository.save(persona);
	}
	
}
