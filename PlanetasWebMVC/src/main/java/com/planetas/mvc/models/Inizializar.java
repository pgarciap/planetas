package com.planetas.mvc.models;

import javax.persistence.Id;

public class Inizializar {
	
	@Id
	private int id_inicio;
	private String estado;
	
	public Inizializar(int id_inicio, String estado) {
		super();
		this.id_inicio = id_inicio;
		this.estado = estado;
	}
	public int getId_inicio() {
		return id_inicio;
	}
	public void setId_inicio(int id_inicio) {
		this.id_inicio = id_inicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
