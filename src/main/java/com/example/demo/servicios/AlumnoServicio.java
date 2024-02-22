package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.modelos.Alumno; 
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@Service
public class AlumnoServicio {
	@Autowired
	private Faker faker; 
	
	private List<Alumno> estudiantes = new ArrayList<>(); 
	
	@PostConstruct
	public void init() {
		for(int i=0;i< 10; i++)
		estudiantes.add(new Alumno(faker.number().randomDigit(), faker.name().name(), faker.funnyName().name(), faker.funnyName().name(), 0, 0));
	}

	public List<Alumno> getEstudiantes() {
		return estudiantes;
	}
	
	public Alumno getAlumnoById(int idalumno) {
		return estudiantes.stream().filter(a -> a.getId_alumno() == idalumno).findAny()				
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						String.format("Usuario %d no encontrado", idalumno)));
		
	}
	
	public Alumno createAlumno(Alumno alumno) {
		if(estudiantes.stream().anyMatch(a -> a.getId_alumno() == alumno.getId_alumno())) {
			
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("El usuario %d ya existe", alumno.getId_alumno())); 
		}
		
		estudiantes.add(alumno);
		return alumno; 
	}
	
	public Alumno updateAlumno(int idalumno, Alumno alumno) {
		Alumno alumnoActualizado = getAlumnoById(idalumno); 
		alumnoActualizado.setNombre(alumno.getNombre());
		alumnoActualizado.setGrado(alumno.getGrado());
		
		return alumnoActualizado; 
	}
	
	public void deleteAlumno(int id_usuario) {
		Alumno alumnoaeliminar = getAlumnoById(id_usuario); 
		estudiantes.remove(alumnoaeliminar); 
	}


	
	
	
}
