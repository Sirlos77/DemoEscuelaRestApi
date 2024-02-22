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

import com.example.demo.servicios.MateriaServicio;

import com.example.demo.entidades.Materia;

@RestController
@RequestMapping("/Materias")
public class MateriaControlador {
	
	@Autowired
	private MateriaServicio servicio; 
	
	@GetMapping
	public ResponseEntity<List<Materia>> getMaterias(){
		return new ResponseEntity<List<Materia>>(servicio.getMaterias(), HttpStatus.OK);
	}
	
	@GetMapping("/{id_materia}")
	public ResponseEntity<Materia> getMateriasById(@PathVariable("id_materia")Integer id_materia){
		return servicio.getMateriasById(id_materia); 
	}
	
	@PostMapping
	public ResponseEntity<Materia> createMateria(@RequestBody Materia materia){
		return new ResponseEntity<Materia> (servicio.createMateria(materia), HttpStatus.CREATED); 		
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<String> updateMateria(@PathVariable("id")int id_materia, @RequestBody Materia materia){
		return servicio.updateMateria(id_materia, materia); 		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> deleteMateria(@PathVariable("id") int id_materia){
		
		return servicio.deleteMateria(id_materia); 
		
	}

}
