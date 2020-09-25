package com.planetas.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetas.mvc.models.Planeta;
import com.planetas.mvc.services.PlanetaService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PlanetasController {

	
	@Autowired 
	private PlanetaService planetaService;

	// Obtener todas las planetas
	@GetMapping("/todosPlanetas")
	public List<Planeta> consultarTodasPersonas(){
		List<Planeta> listaPlanetas = planetaService.getAllPlanetas();
		return listaPlanetas;
	}
	// actualizar contador
	@PutMapping("/CantidadVisitasPlaneta/{id}")
	public void createEmployee(@PathVariable("id") int id) {
		planetaService.saveorUpdate(id);
	}
}
