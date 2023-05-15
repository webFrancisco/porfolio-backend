package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Habilidades;

public interface IHabilidadesService {
  public List<Habilidades> verHabilidades(Long id);

  public void crearHabilidad(Habilidades habilidad, Long id);

  public void modificarHabilidad(Habilidades habilidad, Long idPer, Long idExp);

  public void borrarHabilidad(Long id);

  public Habilidades buscarHabilidad(Long id);
}
