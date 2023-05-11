package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Formacion;

public interface IFormacionService {
  public List<Formacion> verFormacions(Long id);

  public void crearFormacion(Formacion proyecto, Long id);

  public void borrarFormacion(Long id);

  public Formacion buscarFormacion(Long id);
}
