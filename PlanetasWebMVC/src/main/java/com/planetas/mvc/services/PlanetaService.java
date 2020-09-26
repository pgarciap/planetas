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

	public Planeta getPlanetabyId (int id) {
		
		return planetaRepository.findById(id).get();
	}

	public void saveorUpdate(int idPlaneta) {
		Planeta planeta = new Planeta();
		planeta = getPlanetabyId(idPlaneta);
		planeta.setCantidad_vistas(planeta.getCantidad_vistas()+1);
		planetaRepository.save(planeta);
	}
	
	public List<Planeta> getTopPlanetas(){
		List<Planeta> planetas = new ArrayList<Planeta>();
		planetaRepository.findAll().forEach(planeta -> planetas.add(planeta));
		planetas.sort(Comparator.comparing(Planeta::getCantidad_vistas).reversed());
		for (int i = 0; i < planetas.size(); i++) {
		   if (i>= 3) {
			   planetas.remove(i);
		   }
		}
		return planetas;
	}
	
	public void inicializarPlanetas() {
		planetaRepository.save(new Planeta(1,"Mercurio","58d 15h 30m","Caliente","Rocoso",2,0));
		planetaRepository.save(new Planeta(2,"Venus","116d 18h 0m","Caliente","Rocoso",2,0));
		planetaRepository.save(new Planeta(3,"Tierra","0d 24h 0m","Calido","Rocoso",3,0));
		planetaRepository.save(new Planeta(4,"Marte","1d 0h 37m","Frio","Rocoso",1,0));
		planetaRepository.save(new Planeta(5,"Jupiter","0d 9h 56m","Frio","Rocoso",2,0));
	}
	
}
