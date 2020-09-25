package com.planetas.mvc.services;

import java.util.ArrayList;
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
		planetaRepository.findAll().forEach(persona -> planetas.add(persona));
		
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
}
