package com.planetas.mvc.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.planetas.mvc.models.Planeta;

@Repository
public interface PlanetaRepository extends CrudRepository <Planeta, Integer> {}


