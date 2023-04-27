package com.porfolio.PorfolioWebSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.service.IPersonaService;

@RestController
public class Controller {
    @Autowired
    private IPersonaService persoServ;

    @GetMapping("/hola")
    public String decirHola() {
        return "Hola";
    }

    @PostMapping("/nueva/persona")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }

    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    @DeleteMapping("/borrar/persona/{id}")
    public void borrarpersona(@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }

    @GetMapping("/ver/persona/{id}")
    public Persona verpersona(@PathVariable Long id) {
        return persoServ.buscarPersona(id);
    }
}
