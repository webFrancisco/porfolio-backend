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
@RequestMapping("/personas")
public class Controller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IExperienciaService experienciaService;

    @GetMapping("/{id}")
    public PersonaDTO buscarPersona(@PathVariable Long id) {
        return personaService.buscarPersona(id);
    }

    @PostMapping
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @PutMapping("/{id}")
    public void actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        personaService.actualizarPersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

    @PostMapping("/{id}/verificarpass")
    public ResponseEntity<String> verifyPassword(@PathVariable Long id, @RequestBody Map<String, String> passwordMap) {
        String password = passwordMap.get("password");
        if (personaService.compararPass(id, password)) {
            return ResponseEntity.ok("ok");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error");
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

    @DeleteMapping("/delete/experiencia/{id}")
    public void borrarexperiencia(@PathVariable Long id) {
        experienciaService.borrarExperiencia(id);
    }
}
