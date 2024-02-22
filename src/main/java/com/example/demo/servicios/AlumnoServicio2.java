package com.example.demo.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.repositorios.AlumnoRepositorio;
import com.example.demo.entidades.Alumno; 

@Service
public class AlumnoServicio2 {
	
	@Autowired
	private AlumnoRepositorio repositorio; 
	
	public List<Alumno> getAlumnos(){	

		List<Alumno> findAll  = repositorio.findAll(); 
		
		return findAll; 		
	}
	
	public ResponseEntity<Alumno> getAlumnoById(int id_alumno){
		
		Optional<Alumno> optionalAlumno = repositorio.findById(id_alumno);
        return optionalAlumno.map(alumno -> ResponseEntity.ok().body(alumno))
                .orElseGet(() -> ResponseEntity.notFound().build());
		
	}
	
	public Alumno createAlumno(Alumno alumno) {

		return repositorio.save(alumno); //retorna el elemento que le pasamos con las llaves ya generadas
	}
	
	public Alumno updateAlumno(Integer id_alumno, Alumno alumno) {
		
		if(repositorio.findById(id_alumno).isPresent()) {
			
			return repositorio.save(alumno); 			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El usuario %d no existe", id_alumno)); 
		}		
	}

	public void deleteAlumno(Integer id_alumno) {
		Optional <Alumno> alumno = repositorio.findById(id_alumno); 
		
		if(alumno.isPresent()) {
			repositorio.delete(alumno.get());			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("El usuario %d no existe", id_alumno));
		}
		
	}
	
	

}
