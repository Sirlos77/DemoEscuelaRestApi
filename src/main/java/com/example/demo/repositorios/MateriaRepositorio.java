package com.example.demo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Materia; 

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Integer>{
	


}
