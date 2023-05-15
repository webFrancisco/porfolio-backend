package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Formacion;

public interface IFormacionService {
  public List<Formacion> verFormaciones(Long id);

  public void crearFormacion(Formacion formacion, Long id);

  public void modificarFormacion(Formacion formacion, Long idPer, Long idForm);

  public void borrarFormacion(Long id);

  public Formacion buscarFormacion(Long id);
}
