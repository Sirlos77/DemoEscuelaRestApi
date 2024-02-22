package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Alumno; 

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {

}
