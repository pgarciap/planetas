package com.planetas.mvc.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Planeta {
	@Id
	private int id_planeta;
	private String nombre;
	private String periodo_rotacion;
	private String clima;
	private String terreno;
	private int cantidad_personas;
	private int cantidad_vistas;
	
	public Planeta() {
		
	}

	public Planeta(int id_planeta, String nombre, String periodo_rotacion, String clima, String terreno,
			int cantidad_personas, int cantidad_vistas) {
		super();
		this.id_planeta = id_planeta;
		this.nombre = nombre;
		this.periodo_rotacion = periodo_rotacion;
		this.clima = clima;
		this.terreno = terreno;
		this.cantidad_personas = cantidad_personas;
		this.cantidad_vistas = cantidad_vistas;
	}

	public int getId_planeta() {
		return id_planeta;
	}

	public void setId_planeta(int id_planeta) {
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

	public int getCantidad_personas() {
		return cantidad_personas;
	}

	public void setCantidad_personas(int cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}

	public int getCantidad_vistas() {
		return cantidad_vistas;
	}

	public void setCantidad_vistas(int cantidad_vistas) {
		this.cantidad_vistas = cantidad_vistas;
	}
	
	

}
