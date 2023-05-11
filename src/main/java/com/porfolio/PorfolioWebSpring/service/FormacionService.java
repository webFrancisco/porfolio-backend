package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.PorfolioWebSpring.model.Formacion;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.repository.FormacionRepository;
import com.porfolio.PorfolioWebSpring.repository.PersonaRepository;

@Service
public class FormacionService implements IFormacionService {

  @Autowired
  private FormacionRepository formacionRepository;

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public List<Formacion> verFormacions(Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    return formacionRepository.findByPersona(persona);
  }

  @Override
  public void crearFormacion(Formacion formacion, Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    formacion.setPersona(persona);

    formacionRepository.save(formacion);
  }

  @Override
  public void borrarFormacion(Long id) {
    formacionRepository.deleteById(id);
  }

  @Override
  public Formacion buscarFormacion(Long id) {
    return formacionRepository.findById(id).orElse(null);
  }

}
