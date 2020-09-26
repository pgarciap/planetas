package com.planetas.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetas.mvc.models.Inizializar;
import com.planetas.mvc.services.InizializarDataService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InizializarController {
	
	@Autowired 
	private InizializarDataService inizializarDataService;
	
	// actualizar contador
		@GetMapping("/InicializarData")
		public Inizializar actualizarCantidadVisitasPlaneta() {
			inizializarDataService.inicializarData();
			return new Inizializar(1,"ok");
		}
}
