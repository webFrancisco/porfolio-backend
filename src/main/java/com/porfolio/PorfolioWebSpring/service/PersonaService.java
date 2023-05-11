package com.porfolio.PorfolioWebSpring.service;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.model.PersonaDTO;
import com.porfolio.PorfolioWebSpring.repository.PersonaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    public PersonaRepository persoRepo;

    // @Override
    // public List<Persona> verPersonas() {
    // return persoRepo.findAll();
    // }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void actualizarPersona(Long id, Persona per) {
        per.setId(id);
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    // @Override
    // public Persona buscarPersona(Long id) {
    // return persoRepo.findById(id).orElse(null);
    // }

    @Override
    public PersonaDTO buscarPersona(Long id) {
        Persona persona = persoRepo.findById(id).orElse(null);
        if (persona == null) {
            return null;
        }

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setEmail(persona.getEmail());
        personaDTO.setAcercaDe(persona.getAcercaDe());
        personaDTO.setEnlaceGithub(persona.getEnlaceGithub());
        personaDTO.setEnlaceLinkedin(persona.getEnlaceLinkedin());
        personaDTO.setTitulo(persona.getTitulo());

        return personaDTO;
    }

    @Override
    public boolean compararPass(Long id, String pass) {

        Persona persona = persoRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Persona not found with id: " + id));

        return pass.equals(persona.getPassword());

    }

}
