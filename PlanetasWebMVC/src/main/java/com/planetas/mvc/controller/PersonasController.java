package com.planetas.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetas.mvc.models.Persona;
import com.planetas.mvc.services.PersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonasController {
	
		@Autowired 
		private PersonaService personaService;

		// Obtener todas las personas
		@GetMapping("/Personas")
		public List<Persona> consultarTodasPersonas(){
			List<Persona> listaPersonas = personaService.getAllPersonas();
			return listaPersonas;
		}
		// actualizar contador
		@GetMapping("/CantidadVisitas/{id}")
		public Persona consultarPersonaId(@PathVariable("id") int id) throws Exception {
			 personaService.saveorUpdate(id);
			 return personaService.getPersonabyId(id);
		}
		
		// Obtener top las personas
		@GetMapping("/TopPersonas")
		public List<Persona> TopPersonas(){
			List<Persona> listaPersonas = personaService.getTopPersonas();
			return listaPersonas;
		}
		 
}
