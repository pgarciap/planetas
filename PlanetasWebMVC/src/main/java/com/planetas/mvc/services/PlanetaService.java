package com.planetas.mvc.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetas.mvc.models.Planeta;
import com.planetas.mvc.repositories.PlanetaRepository;

/**
 * Servicio planetaService.
 * servicio encargado de consultar la base de datos H2 de la tabla planeta
 *
 * @autor Paola Garcia
 * @version 1.0 - 26/09/2020
 */
@Service
public class PlanetaService {

	@Autowired
	PlanetaRepository planetaRepository;
	
	/**
	   * Obtener todas los planetas
	   * Metodo encargado de entregar lista de planetas
	   * @return lista Planetas
	   */
	public List<Planeta> getAllPlanetas(){
		List<Planeta> planetas = new ArrayList<Planeta>();
		planetaRepository.findAll().forEach(planeta -> planetas.add(planeta));
		
		return planetas;
	}
	
	/**
	   * buscar planeta por id
	   * Metodo encargado buscar el planeta con el id ingresado
	   * @param id - id del planeta a consultar
	   * @return modelo planeta
	   * @throws error al no encontrar la planeta
	   */
	public Planeta getPlanetabyId (int id) throws Exception {
		
		Planeta planeta = new Planeta();
		planeta = planetaRepository.findById(id).get();
		
		if (planeta == null)
			throw new Exception("Error al buscar ID planeta  - PlanetaService.getPlanetabyId");
		
		return planeta;
	}
	
	/**
	   * Actualizar cantidad visitas por planeta
	   * Metodo encargado actualizar la cantidad de visitas por planeta
	   * @param id - id del planeta a actualizar
	   * @throws error al no encontrar planeta
	   */
	public void saveorUpdate(int idPlaneta) throws Exception {
		Planeta planeta = new Planeta();
		planeta = getPlanetabyId(idPlaneta);
		
		if (planeta == null)
			throw new Exception("Error al buscar ID planeta  - PlanetaService.saveorUpdate");
		
		planeta.setCantidad_vistas(planeta.getCantidad_vistas()+1);
		planetaRepository.save(planeta);
	}
	
	/**
	   * Top 3 planetas
	   * Metado encargado de consultar los 3 primeros personas con mas visitas
	   * @return Lista planetas
	   */
	public List<Planeta> getTopPlanetas(){
		int i=0;
		List<Planeta> planetas = new ArrayList<Planeta>();
		List<Planeta> planetasTop = new ArrayList<Planeta>();
		planetaRepository.findAll().forEach(planeta -> planetas.add(planeta));
		planetas.sort(Comparator.comparing(Planeta::getCantidad_vistas).reversed());
		for (Planeta planeta2 : planetas) {
			if (i<3) {
				planetasTop.add(planeta2);
			}
			i++;
		}
		return planetasTop;
	}
	
	/**
	   * Inicializar personas
	   * Metado encargado de cargar planetas por defecto
	   */
	public void inicializarPlanetas() {
		planetaRepository.save(new Planeta(1,"Mercurio","58d 15h 30m","Caliente","Rocoso",2,0));
		planetaRepository.save(new Planeta(2,"Venus","116d 18h 0m","Caliente","Rocoso",2,0));
		planetaRepository.save(new Planeta(3,"Tierra","0d 24h 0m","Calido","Rocoso",3,0));
		planetaRepository.save(new Planeta(4,"Marte","1d 0h 37m","Frio","Rocoso",1,0));
		planetaRepository.save(new Planeta(5,"Jupiter","0d 9h 56m","Frio","Rocoso",2,0));
	}
	
}
