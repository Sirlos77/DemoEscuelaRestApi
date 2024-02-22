package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Alumno;
import com.example.demo.entidades.Calificacion;
import com.example.demo.repositorios.AlumnoRepositorio;
import com.example.demo.repositorios.CalificacionRepositorio;
import com.example.demo.servicios.CalificacionServicio;


@RestController
@RequestMapping("/informacion-alumnos")
public class CalificacionControlador {
	
	@Autowired
	private CalificacionServicio servicio; 
	
	  @Autowired
	    private AlumnoRepositorio alumno_repositorio;

	    @Autowired
	    private CalificacionRepositorio calificacion_repositorio;
	
	@GetMapping
	public ResponseEntity<List<Calificacion>> getAllInformacionCalificacion(){
		return new ResponseEntity<List<Calificacion>>(servicio.getInformacionCalificacion(), HttpStatus.OK);
	}
	
	
	//@PostMapping("/{idAlumno}/agregar-materia")
	//public ResponseEntity<String> agregarMateria(@PathVariable("idAlumno") int idAlumno, @RequestBody Calificacion calificacion){
		//return servicio.agregarMateria(idAlumno, calificacion); 
	//}
	
    private Double calcularPromedioGeneral(List<Calificacion> calificaciones) {
        double sumaNotas = 0.0;
        for (Calificacion calificacion : calificaciones) {
            sumaNotas += calificacion.getPromedio();
        }
        return sumaNotas / calificaciones.size();
    }
	
	@PostMapping("/agregarMateria/{idAlumno}")
    public ResponseEntity<String> agregarMateria(@PathVariable("idAlumno") Integer idAlumno, @RequestBody Calificacion calificacion) {
       
		
		
		Optional<Alumno> optionalAlumno = alumno_repositorio.findById(idAlumno);
		
		

        return optionalAlumno.map(alumno -> {
            //if (alumno.getCalificaciones().size() > 5) {
        	
                calificacion.setAlumno(alumno);
                calificacion_repositorio.save(calificacion);

                
               Double promedioGeneral = calcularPromedioGeneral(alumno.getCalificaciones());
                alumno.setPromedio_general(promedioGeneral);
                alumno_repositorio.save(alumno);

                return ResponseEntity.ok("Materia agregada exitosamente");
            //} else {
                //return ResponseEntity.badRequest().body("El alumno tiene menos de 5 materias, necesita agregar más");
            //}
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
