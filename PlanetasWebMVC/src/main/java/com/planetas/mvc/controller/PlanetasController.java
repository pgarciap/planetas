package com.planetas.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetas.mvc.models.Planeta;
import com.planetas.mvc.services.PlanetaService;

/**
 * Controller Planetas.
 * Servicio rest encargado de realizar las diferentes consultas relacionadas a planetas
 *
 * @autor Paola Garcia
 * @version 1.0 - 26/09/2020
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PlanetasController {

	
	@Autowired 
	private PlanetaService planetaService;

	/**
	   * Obtener todas los planetas
	   * metodo encargado de cargar todas la lista de planetas
	   * @param Metodo HHTP Get /todosPlanetas
	   * @return Lista Personas
	   */
	@GetMapping("/todosPlanetas")
	public List<Planeta> consultarTodosPlanetas(){
		List<Planeta> listaPlanetas = planetaService.getAllPlanetas();
		return listaPlanetas;
	}
	
	/**
	   * ConsultarPlanetaID
	   * Metodo encargado de consultar planeta por Id y actualizar la cantidad de visitas
	   * @param Metodo HHTP Get /CantidadVisitasPlaneta
	   * @return Modelo Planeta
	   */
	@GetMapping("/CantidadVisitasPlaneta/{id}")
	public Planeta consultarPlanetaId(@PathVariable("id") int id) throws Exception {
		planetaService.saveorUpdate(id);
		return planetaService.getPlanetabyId(id);
	}
	
	/**
	   * consultar Top 3 Planetas
	   * Metodo encargado de consultar planetas con mas visitas y obtner los 3 primeros puestos
	   * @param Metodo HHTP Get /TopPlanetas
	   * @return Lista Planetas
	   */
	@GetMapping("/TopPlanetas")
	public List<Planeta> TopPlanetas(){
		List<Planeta> listaPlanetas = planetaService.getTopPlanetas();
		return listaPlanetas;
	}
	
}
