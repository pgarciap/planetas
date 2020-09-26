package com.planetas.mvc.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetas.mvc.models.Planeta;
import com.planetas.mvc.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	PlanetaRepository planetaRepository;

	public List<Planeta> getAllPlanetas(){
		List<Planeta> planetas = new ArrayList<Planeta>();
		planetaRepository.findAll().forEach(planeta -> planetas.add(planeta));
		
		return planetas;
	}

	public Planeta getPlanetabyId (int id) throws Exception {
		
		Planeta planeta = new Planeta();
		planeta = planetaRepository.findById(id).get();
		
		if (planeta == null)
			throw new Exception("Error al buscar ID planeta  - PlanetaService.getPlanetabyId");
		
		return planeta;
	}

	public void saveorUpdate(int idPlaneta) throws Exception {
		Planeta planeta = new Planeta();
		planeta = getPlanetabyId(idPlaneta);
		
		if (planeta == null)
			throw new Exception("Error al buscar ID planeta  - PlanetaService.saveorUpdate");
		
		planeta.setCantidad_vistas(planeta.getCantidad_vistas()+1);
		planetaRepository.save(planeta);
	}
	
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
	
	public void inicializarPlanetas() {
		planetaRepository.save(new Planeta(1,"Mercurio","58d 15h 30m","Caliente","Rocoso",2,0));
		planetaRepository.save(new Planeta(2,"Venus","116d 18h 0m","Caliente","Rocoso",2,0));
		planetaRepository.save(new Planeta(3,"Tierra","0d 24h 0m","Calido","Rocoso",3,0));
		planetaRepository.save(new Planeta(4,"Marte","1d 0h 37m","Frio","Rocoso",1,0));
		planetaRepository.save(new Planeta(5,"Jupiter","0d 9h 56m","Frio","Rocoso",2,0));
	}
	
}
