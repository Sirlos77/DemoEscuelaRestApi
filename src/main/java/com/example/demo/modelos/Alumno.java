package com.example.demo.modelos;

public class Alumno {
	
	private int id_alumno; 
	private String nombre; 
	private String apellido_p; 
	private String apellido_m; 
	private int grado; 
	private double promedio_general;

	public Alumno() {
		
	}
	
	public Alumno(int id_alumno, String nombre, String apellido_p, String apellido_m, int grado, double promedio_general) {
		super();
		this.id_alumno = id_alumno; 
		this.nombre = nombre;
		this.apellido_p = apellido_p;
		this.apellido_m = apellido_m;
		this.grado = grado;
		this.promedio_general = promedio_general;
	}
	
	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_p() {
		return apellido_p;
	}

	public void setApellido_p(String apellido_p) {
		this.apellido_p = apellido_p;
	}

	public String getApellido_m() {
		return apellido_m;
	}

	public void setApellido_m(String apellido_m) {
		this.apellido_m = apellido_m;
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
	
	
	
	

}
