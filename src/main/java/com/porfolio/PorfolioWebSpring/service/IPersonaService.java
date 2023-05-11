package com.porfolio.PorfolioWebSpring.service;

// import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.model.PersonaDTO;

public interface IPersonaService {
    // public List<Persona> verPersonas();

    public PersonaDTO buscarPersona(Long id);

    public void crearPersona(Persona per);

    public void actualizarPersona(Long id, Persona per);

    public void borrarPersona(Long id);

    public boolean compararPass(Long id, String pass);

}
