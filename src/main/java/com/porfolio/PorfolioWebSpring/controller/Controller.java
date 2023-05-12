package com.porfolio.PorfolioWebSpring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.porfolio.PorfolioWebSpring.model.Experiencia;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.model.PersonaDTO;
import com.porfolio.PorfolioWebSpring.service.IExperienciaService;
import com.porfolio.PorfolioWebSpring.service.IPersonaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personas")
public class Controller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IExperienciaService experienciaService;

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
}
