package com.example.demo.entidades;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_materia", nullable = false, unique = true, columnDefinition = "int")
	private int id_materia; 
	
	
	@Column(name="nombre", nullable = false, columnDefinition = "varchar(255)")
	private String materia; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
	private List<Calificacion> calificaciones; 
	
	
	

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_materia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return id_materia == other.id_materia;
	}
	
	
	
	
	
	
	

}
