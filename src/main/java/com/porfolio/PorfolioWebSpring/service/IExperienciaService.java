package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Experiencia;

public interface IExperienciaService {
  public List<Experiencia> verExperiencias(Long id);

  public void crearExperiencia(Experiencia proyecto, Long id);

  public void borrarExperiencia(Long id);

  public Experiencia buscarExperiencia(Long id);
}
