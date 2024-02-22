package com.example.demo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Calificacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_calificacion", nullable = false, unique = true, columnDefinition = "int")
	private int id_calificacion; 
	
	@ManyToOne
	@JoinColumn(name="id_alumno", nullable=false)
	private Alumno alumno; 
	
	@ManyToOne
	@JoinColumn(name="id_materia", nullable= false)
	private Materia materia; 
	
	@Column(name="promedio", nullable = false, columnDefinition = "double")
	private double promedio;

	public int getId_calificacion() {
		return id_calificacion;
	}

	public void setId_calificacion(int id_calificacion) {
		this.id_calificacion = id_calificacion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	} 
	
	
	


}
