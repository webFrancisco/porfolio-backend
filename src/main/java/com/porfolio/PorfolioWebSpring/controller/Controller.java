package com.porfolio.PorfolioWebSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.porfolio.PorfolioWebSpring.model.Experiencia;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.service.IExperienciaService;
import com.porfolio.PorfolioWebSpring.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class Controller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IExperienciaService experienciaService;

    @GetMapping("/hola")
    public String decirHola() {
        return "Hola";
    }

    @GetMapping
    public List<Persona> listaPersonas() {
        return personaService.verPersonas();
    }

    @PostMapping
    public void agregarPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @GetMapping("/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
        return personaService.buscarPersona(id);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

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
