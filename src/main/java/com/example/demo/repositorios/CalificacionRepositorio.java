package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Calificacion;

public interface  CalificacionRepositorio extends JpaRepository<Calificacion, Integer> {

}
