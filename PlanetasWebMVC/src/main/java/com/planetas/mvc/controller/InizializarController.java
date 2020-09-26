package com.planetas.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetas.mvc.models.Inizializar;
import com.planetas.mvc.services.InizializarDataService;

/**
 * Controller Inicializar.
 * Servicio rest encargado de inicializar variables
 *
 * @autor Paola Garcia
 * @version 1.0 - 26/09/2020
 */


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InizializarController {
	
	@Autowired 
	private InizializarDataService inizializarDataService;
	
	/**
	   * Inicializar data
	   * Se encarga de cargar valores por defecto para personas y planetas
	   * @param Metodo HHTP Get /InicializarData
	   * @return Modelo Inicializar
	   */
		@GetMapping("/InicializarData")
		public Inizializar cargarData() {
			inizializarDataService.inicializarData();
			return new Inizializar(1,"ok");
		}
}
