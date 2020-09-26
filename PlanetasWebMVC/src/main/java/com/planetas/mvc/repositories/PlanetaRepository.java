package com.planetas.mvc.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.planetas.mvc.models.Planeta;

/**
 * Interfaz PlanetaRepository.
 * Interfaz encargada de realizar una extencion con la clase CrudRepository
 *
 * @autor Paola Garcia
 * @version 1.0 - 26/09/2020
 */
@Repository
public interface PlanetaRepository extends CrudRepository <Planeta, Integer> {}


