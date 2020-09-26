package com.planetas.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio InicializarData.
 * servicio encargado de inicializar personas y planetas por defecto
 *
 * @autor Paola Garcia
 * @version 1.0 - 26/09/2020
 */
@Service
public class InizializarDataService {
	
	@Autowired
	private PersonaService personaService;
	@Autowired 
	private PlanetaService planetaService;
	
	/**
	   * Inicializar data
	   * Se encarga de cargar valores por defecto para personas y planetas
	   * @return NA
	   */
	public void inicializarData() {
		personaService.inicializarPersonas();
		planetaService.inicializarPlanetas();
	}

}
