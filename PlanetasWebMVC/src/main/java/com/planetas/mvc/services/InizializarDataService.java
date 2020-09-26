package com.planetas.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class InizializarDataService {
	
	@Autowired
	private PersonaService personaService;
	@Autowired 
	private PlanetaService planetaService;
	
	public void inicializarData() {
		personaService.inicializarPersonas();
		planetaService.inicializarPlanetas();
	}

}
