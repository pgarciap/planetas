package com.planetas.mvc.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Planeta {
	@Id
	private Integer id_planeta;
	private String nombre;
	private String periodo_rotacion;
	private String clima;
	private String terreno;
	private Integer cantidad_personas;
	private Integer cantidad_vistas;
	
	public Planeta() {
		
	}

	public Planeta(Integer id_planeta, String nombre, String periodo_rotacion, String clima, String terreno,
			Integer cantidad_personas, Integer cantidad_vistas) {
		super();
		this.id_planeta = id_planeta;
		this.nombre = nombre;
		this.periodo_rotacion = periodo_rotacion;
		this.clima = clima;
		this.terreno = terreno;
		this.cantidad_personas = cantidad_personas;
		this.cantidad_vistas = cantidad_vistas;
	}

	public Integer getId_planeta() {
		return id_planeta;
	}

	public void setId_planeta(Integer id_planeta) {
		this.id_planeta = id_planeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPeriodo_rotacion() {
		return periodo_rotacion;
	}

	public void setPeriodo_rotacion(String periodo_rotacion) {
		this.periodo_rotacion = periodo_rotacion;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getCantidad_personas() {
		return cantidad_personas;
	}

	public void setCantidad_personas(Integer cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}

	public Integer getCantidad_vistas() {
		return cantidad_vistas;
	}

	public void setCantidad_vistas(Integer cantidad_vistas) {
		this.cantidad_vistas = cantidad_vistas;
	}
	
	

}
