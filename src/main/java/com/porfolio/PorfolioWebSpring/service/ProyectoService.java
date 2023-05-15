package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.PorfolioWebSpring.model.Proyecto;
import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.repository.ProyectoRepository;
import com.porfolio.PorfolioWebSpring.repository.PersonaRepository;

@Service
public class ProyectoService implements IProyectoService {

  @Autowired
  private ProyectoRepository proyectoRepository;

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public List<Proyecto> verProyectos(Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    return proyectoRepository.findByPersona(persona);
  }

  @Override
  public void crearProyecto(Proyecto proyecto, Long id) {

    Persona persona = personaRepository.findById(id).orElse(null);

    proyecto.setPersona(persona);

    proyectoRepository.save(proyecto);
  }

  @Override
  public void modificarProyecto(Proyecto proyecto, Long idPer, Long idExp) {

    Persona persona = personaRepository.findById(idPer).orElse(null);

    proyecto.setPersona(persona);
    proyecto.setId(idExp);

    proyectoRepository.save(proyecto);
  }

  @Override
  public void borrarProyecto(Long id) {
    proyectoRepository.deleteById(id);
  }

  @Override
  public Proyecto buscarProyecto(Long id) {
    return proyectoRepository.findById(id).orElse(null);
  }

}
