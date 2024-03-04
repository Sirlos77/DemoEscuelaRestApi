package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Alumno;
import com.example.demo.servicios.AlumnoServicio2;

@RestController
@RequestMapping("/Alumnos")
public class AlumnoControlador2 {
	
	@Autowired
	private AlumnoServicio2 servicio; 
	
	
	@GetMapping
	public ResponseEntity<List<Alumno>> getAlumnos(){
		return new ResponseEntity<List<Alumno>>(servicio.getAlumnos(), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id_alumno}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable("id_alumno")int id_alumno){
		return servicio.getAlumnoById(id_alumno); 
	}
	
	
	@PostMapping
	public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
		return new ResponseEntity<Alumno>(servicio.createAlumno(alumno), HttpStatus.CREATED);		
	}
	
	@PutMapping("/{idusuario}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("idusuario") Integer id_usuario, @RequestBody Alumno alumno){
		System.out.println("hola si me ejecuto");
		return new ResponseEntity<Alumno>(servicio.updateAlumno(id_usuario, alumno), HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/{idusuario}")
	public ResponseEntity<Alumno> deleteAlumno(@PathVariable("idusuario") Integer id_usuario){
		// servicio.deleteAlumno(id_usuario); 
		// return new ResponseEntity<>(HttpStatus.NO_CONTENT); 

		return new ResponseEntity<Alumno>(servicio.deleteAlumno(id_usuario), HttpStatus.NO_CONTENT); 
		
	}

}
