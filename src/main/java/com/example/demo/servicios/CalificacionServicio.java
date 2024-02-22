package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repositorios.AlumnoRepositorio;
import com.example.demo.repositorios.CalificacionRepositorio;

import com.example.demo.entidades.Alumno;
import com.example.demo.entidades.Calificacion;

@Service
public class CalificacionServicio {
	
    @Autowired
    private AlumnoRepositorio alumno_repositorio;

    @Autowired
    private CalificacionRepositorio calificacion_repositorio;
    

    
    public List<Calificacion> getInformacionCalificacion() {
        return calificacion_repositorio.findAll();
    }
    
    private Double calcularPromedioGeneral(List<Calificacion> calificaciones) {
        double sumaNotas = 0.0;
        for (Calificacion calificacion : calificaciones) {
            sumaNotas += calificacion.getPromedio();
        }
        return sumaNotas / calificaciones.size();
    }
    
 
    public ResponseEntity<String> agregarMateria(Integer idAlumno, Calificacion calificacion) {
        Optional<Alumno> optionalAlumno = alumno_repositorio.findById(idAlumno);
        
        System.out.println(optionalAlumno); 

        return optionalAlumno.map(alumno -> {
        		
                calificacion.setAlumno(alumno);
                calificacion_repositorio.save(calificacion);

                
                Double promedioGeneral = calcularPromedioGeneral(alumno.getCalificaciones());
                alumno.setPromedio_general(promedioGeneral);
                alumno_repositorio.save(alumno);

                return ResponseEntity.ok("Materia agregada exitosamente");
        
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
