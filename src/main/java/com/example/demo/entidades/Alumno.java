package com.example.demo.entidades;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType; 

@Entity
@Table(name="alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_alumno" )
	private int id_alummno; 
	@Column(name="nombre")
	private String nombre; 
	@Column(name="apellido_paterno")
	private String apellido_paterno; 
	@Column(name="apellido_materno")
	private String apellido_materno; 
	@Column(name="telefono")
	private String telefono; 
	@Column(name="correo")
	private String correo; 
	@Column(name="grado")
	private int grado; 
	@Column(name="promedio_general")
	private double promedio_general;
	
	@JsonIgnore
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
	private List<Calificacion> calificaciones; 

	
	
	
	
	
	
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}


	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public int getId_alummno() {
		return id_alummno;
	}
	public void setId_alummno(int id_alummno) {
		this.id_alummno = id_alummno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	public double getPromedio_general() {
		return promedio_general;
	}
	public void setPromedio_general(double promedio_general) {
		this.promedio_general = promedio_general;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_alummno);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return id_alummno == other.id_alummno;
	} 
	
	
	
	
	

}
