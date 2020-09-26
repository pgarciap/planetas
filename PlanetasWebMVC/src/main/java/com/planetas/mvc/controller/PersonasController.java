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

/**
 * Controller Personas.
 * Servicio rest encargado de realizar las diferentes consultas relacionadas a personas
 *
 * @autor Paola Garcia
 * @version 1.0 - 26/09/2020
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonasController {
	
		@Autowired 
		private PersonaService personaService;
		
		
		/**
		   * Obtener todas las personas
		   * metodo encargado de cargar todas la lista de personas
		   * @param Metodo HHTP Get /InicializarData
		   * @return Lista Personas
		   */
		@GetMapping("/Personas")
		public List<Persona> consultarTodasPersonas(){
			List<Persona> listaPersonas = personaService.getAllPersonas();
			return listaPersonas;
		}
		/**
		   * ConsultarPersonasID
		   * Metodo encargado de consultar persona por Id y actualizar la cantidad de visitas
		   * @param Metodo HHTP Get /CantidadVisitas
		   * @return Modelo Personas
		   */
		// actualizar contador
		@GetMapping("/CantidadVisitas/{id}")
		public Persona consultarPersonaId(@PathVariable("id") int id) throws Exception {
			 personaService.saveorUpdate(id);
			 return personaService.getPersonabyId(id);
		}
		
		/**
		   * consultar Top 3 Personas
		   * Metodo encargado de consultar personas con mas visitas y obtner los 3 primeros puestos
		   * @param Metodo HHTP Get /TopPersonas
		   * @return Lista Personas
		   */
		// Obtener top las personas
		@GetMapping("/TopPersonas")
		public List<Persona> TopPersonas(){
			List<Persona> listaPersonas = personaService.getTopPersonas();
			return listaPersonas;
		}
		 
}
