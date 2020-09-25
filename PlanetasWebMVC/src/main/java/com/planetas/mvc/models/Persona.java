package com.planetas.mvc.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
	
	@Id
	private Integer id_persona;
	private String nombre;
	private Integer edad;
	private Integer altuta;
	private float peso;
	private String genero;
	private String fecha_nacimiento;
	private long cantidad_visitas;
	private Integer id_planeta;
	
	public Persona() {
		
	}

	public Persona(Integer id_persona, String nombre, Integer edad, Integer altuta, float peso, String genero,
			String fecha_nacimiento, long cantidad_visitas, Integer id_planeta) {
		super();
		this.id_persona = id_persona;
		this.nombre = nombre;
		this.edad = edad;
		this.altuta = altuta;
		this.peso = peso;
		this.genero = genero;
		this.fecha_nacimiento = fecha_nacimiento;
		this.cantidad_visitas = cantidad_visitas;
		this.id_planeta = id_planeta;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getAltuta() {
		return altuta;
	}

	public void setAltuta(Integer altuta) {
		this.altuta = altuta;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public long getCantidad_visitas() {
		return cantidad_visitas;
	}

	public void setCantidad_visitas(long cantidad_visitas) {
		this.cantidad_visitas = cantidad_visitas;
	}

	public Integer getId_planeta() {
		return id_planeta;
	}

	public void setId_planeta(Integer id_planeta) {
		this.id_planeta = id_planeta;
	}
	
	
}
