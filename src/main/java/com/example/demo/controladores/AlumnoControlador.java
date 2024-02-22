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

import com.example.demo.modelos.Alumno;
import com.example.demo.servicios.AlumnoServicio; 

@RestController
//Definición de mi recurso
@RequestMapping("/Alumnoszzz")
public class AlumnoControlador {
	
	@Autowired //Inyeccion del servicio AlumnoServicio
	private AlumnoServicio alumnoservicio; 
	
	@GetMapping
	//Metod http + recurso -> handler methods
	public ResponseEntity<List<Alumno>> getAlumnos(){
		return new ResponseEntity<List<Alumno>>(alumnoservicio.getEstudiantes(), HttpStatus.OK);		
	}
	
	@GetMapping(value="/{idalumno}")	
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable("idalumno")int idAlumno){
		return new ResponseEntity<Alumno>(alumnoservicio.getAlumnoById(idAlumno), HttpStatus.OK); 
		
	}
	
	@PostMapping
	public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
		return new ResponseEntity<Alumno>(alumnoservicio.createAlumno(alumno), HttpStatus.CREATED); 
	}
	
	@PutMapping("/{idusuario}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("idusuario") int idalumno, @RequestBody Alumno alumno){
		return new ResponseEntity<Alumno>(alumnoservicio.updateAlumno(idalumno, alumno), HttpStatus.OK); 
	}
	
	@DeleteMapping("/{idusuario}")
	public ResponseEntity<Alumno> eliminarAlumno(@PathVariable("idusuario") int idalumno){
		alumnoservicio.deleteAlumno(idalumno);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	

}
