package com.porfolio.PorfolioWebSpring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.porfolio.PorfolioWebSpring.model.Experiencia;
import com.porfolio.PorfolioWebSpring.model.Formacion;
import com.porfolio.PorfolioWebSpring.model.Habilidades;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.model.PersonaDTO;
import com.porfolio.PorfolioWebSpring.model.Proyecto;
import com.porfolio.PorfolioWebSpring.service.IExperienciaService;
import com.porfolio.PorfolioWebSpring.service.IFormacionService;
import com.porfolio.PorfolioWebSpring.service.IHabilidadesService;
import com.porfolio.PorfolioWebSpring.service.IPersonaService;
import com.porfolio.PorfolioWebSpring.service.IProyectoService;

@RestController
@CrossOrigin
@RequestMapping("/personas")
public class Controller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IExperienciaService experienciaService;

    @Autowired
    private IFormacionService formacionService;

    @Autowired
    private IHabilidadesService habilidadesService;

    @Autowired
    private IProyectoService proyectoService;

    // --- PERSONAS ---
    @GetMapping("/{id}")
    public PersonaDTO buscarPersona(@PathVariable Long id) {
        return personaService.buscarPersona(id);
    }

    @PostMapping
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @PutMapping("/{id}")
    public void actualizarPersona(@PathVariable Long id, @RequestBody PersonaDTO persona) {
        personaService.actualizarPersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

    // --- VERIFICAR PASS ---
    @PostMapping("/{id}/verificarpass")
    public ResponseEntity<PersonaDTO> verifyPassword(@PathVariable Long id, @RequestBody Map<String, String> reqMap) {
        String password = reqMap.get("password");
        String email = reqMap.get("email");
        if (personaService.compararPass(id, email, password)) {
            return ResponseEntity.ok(personaService.buscarPersona(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    // --- EXPERIENCIAS ---
    @GetMapping("/{id}/experiencias")
    public List<Experiencia> verexperiencias(@PathVariable Long id) {
        return experienciaService.verExperiencias(id);
    }

    @PostMapping("/{id}/experiencia")
    public void agregarExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        experienciaService.crearExperiencia(experiencia, id);
    }

    @PutMapping("/{idPer}/experiencia/{idExp}")
    public void agregarExperiencia(@PathVariable Long idPer, @PathVariable Long idExp,
            @RequestBody Experiencia experiencia) {
        experienciaService.modificarExperiencia(experiencia, idPer, idExp);
    }

    @DeleteMapping("/{id}/experiencia/{id2}")
    public void borrarexperiencia(@PathVariable Long id2) {
        experienciaService.borrarExperiencia(id2);
    }

    // --- FORMACION ---
    @GetMapping("/{id}/formaciones")
    public List<Formacion> verFormaciones(@PathVariable Long id) {
        return formacionService.verFormaciones(id);
    }

    @PostMapping("/{id}/formacion")
    public void agregarFormacion(@PathVariable Long id, @RequestBody Formacion formacion) {
        formacionService.crearFormacion(formacion, id);
    }

    @PutMapping("/{idPer}/formacion/{idForm}")
    public void agregarFormacion(@PathVariable Long idPer, @PathVariable Long idForm,
            @RequestBody Formacion formacion) {
        formacionService.modificarFormacion(formacion, idPer, idForm);
    }

    @DeleteMapping("/{id}/formacion/{id2}")
    public void borrarFormacion(@PathVariable Long id2) {
        formacionService.borrarFormacion(id2);
    }

    // --- HABILIDADES ---
    @GetMapping("/{id}/habilidades")
    public List<Habilidades> verHabilidades(@PathVariable Long id) {
        return habilidadesService.verHabilidades(id);
    }

    @PostMapping("/{id}/habilidad")
    public void agregarHabilidad(@PathVariable Long id, @RequestBody Habilidades habilidad) {
        habilidadesService.crearHabilidad(habilidad, id);
    }

    @PutMapping("/{idPer}/habilidad/{idForm}")
    public void agregarHabilidad(@PathVariable Long idPer, @PathVariable Long idForm,
            @RequestBody Habilidades habilidad) {
        habilidadesService.modificarHabilidad(habilidad, idPer, idForm);
    }

    @DeleteMapping("/{id}/habilidad/{id2}")
    public void borrarHabilidad(@PathVariable Long id2) {
        habilidadesService.borrarHabilidad(id2);
    }

    // --- PROYECTOS ---
    @GetMapping("/{id}/proyectos")
    public List<Proyecto> verproyectos(@PathVariable Long id) {
        return proyectoService.verProyectos(id);
    }

    @PostMapping("/{id}/proyecto")
    public void agregarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyectoService.crearProyecto(proyecto, id);
    }

    @PutMapping("/{idPer}/proyecto/{idPro}")
    public void agregarProyecto(@PathVariable Long idPer, @PathVariable Long idPro,
            @RequestBody Proyecto proyecto) {
        proyectoService.modificarProyecto(proyecto, idPer, idPro);
    }

    @DeleteMapping("/{id}/proyecto/{id2}")
    public void borrarproyecto(@PathVariable Long id2) {
        proyectoService.borrarProyecto(id2);
    }
}
