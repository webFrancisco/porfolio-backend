package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.PorfolioWebSpring.model.Experiencia;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.repository.ExperienciaRepository;
import com.porfolio.PorfolioWebSpring.repository.PersonaRepository;

@Service
public class ExperienciaService implements IExperienciaService {

  @Autowired
  private ExperienciaRepository experienciaRepository;

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public List<Experiencia> verExperiencias(Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    return experienciaRepository.findByPersona(persona);
  }

  @Override
  public void crearExperiencia(Experiencia experiencia, Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    experiencia.setPersona(persona);

    experienciaRepository.save(experiencia);
  }

  @Override
  public void modificarExperiencia(Experiencia experiencia, Long idPer, Long idExp) {

    Persona persona = personaRepository.findById(idPer).orElse(null);

    experiencia.setPersona(persona);
    experiencia.setId(idExp);

    experienciaRepository.save(experiencia);
  }

  @Override
  public void borrarExperiencia(Long id) {
    experienciaRepository.deleteById(id);
  }

  @Override
  public Experiencia buscarExperiencia(Long id) {
    return experienciaRepository.findById(id).orElse(null);
  }

}
