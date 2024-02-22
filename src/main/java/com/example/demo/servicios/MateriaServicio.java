package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entidades.Materia;

import com.example.demo.repositorios.MateriaRepositorio; 

@Service
public class MateriaServicio {
	
	@Autowired
	private MateriaRepositorio repositorio; 
	
	
	public List<Materia> getMaterias(){
		return repositorio.findAll(); 
	}
	
	public ResponseEntity<Materia> getMateriasById(Integer id_materia){
		 Optional<Materia> optionalMateria = repositorio.findById(id_materia);
	     return optionalMateria.map(materia -> ResponseEntity.ok().body(materia))
	                .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	public Materia createMateria(Materia materia) {				
		return repositorio.save(materia); 
	}
	
	public ResponseEntity<String> updateMateria(Integer id_materia, Materia updmateria){
		Optional<Materia> pmateria = repositorio.findById(id_materia); 
		return pmateria.map(materia -> {
			materia.setMateria(updmateria.getMateria()); 
			repositorio.save(materia); 
			return ResponseEntity.ok("Materia actualizada exitosamente"); 
		}).orElseGet(() -> ResponseEntity.notFound().build());
		
	}
	
	public ResponseEntity<String> deleteMateria(Integer id_materia){
		Optional<Materia> optionalMateria = repositorio.findById(id_materia);
        return optionalMateria.map(materia -> {
            repositorio.delete(materia);
            return ResponseEntity.ok("Materia eliminada exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	

}
