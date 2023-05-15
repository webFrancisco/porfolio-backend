package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.PorfolioWebSpring.model.Habilidades;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.repository.HabilidadesRepository;
import com.porfolio.PorfolioWebSpring.repository.PersonaRepository;

@Service
public class HabilidadesService implements IHabilidadesService {

  @Autowired
  private HabilidadesRepository habilidadesRepository;

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public List<Habilidades> verHabilidades(Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    return habilidadesRepository.findByPersona(persona);
  }

  @Override
  public void crearHabilidad(Habilidades habilidad, Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    habilidad.setPersona(persona);

    habilidadesRepository.save(habilidad);
  }

  @Override
  public void modificarHabilidad(Habilidades habilidad, Long idPer, Long idExp) {

    Persona persona = personaRepository.findById(idPer).orElse(null);

    habilidad.setPersona(persona);
    habilidad.setId(idExp);

    habilidadesRepository.save(habilidad);
  }

  @Override
  public void borrarHabilidad(Long id) {
    habilidadesRepository.deleteById(id);
  }

  @Override
  public Habilidades buscarHabilidad(Long id) {
    return habilidadesRepository.findById(id).orElse(null);
  }

}
