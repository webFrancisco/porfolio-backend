package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Experiencia;

public interface IExperienciaService {
  public List<Experiencia> verExperiencias(Long id);

  public void crearExperiencia(Experiencia experiencia, Long id);

  public void modificarExperiencia(Experiencia experiencia, Long idPer, Long idExp);

  public void borrarExperiencia(Long id);

  public Experiencia buscarExperiencia(Long id);
}
