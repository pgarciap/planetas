package com.planetas.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.planetas.mvc.models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository <Persona, Integer> {}
