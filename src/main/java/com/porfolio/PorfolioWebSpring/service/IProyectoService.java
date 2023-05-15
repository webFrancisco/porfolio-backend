package com.porfolio.PorfolioWebSpring.service;

import java.util.List;

import com.porfolio.PorfolioWebSpring.model.Proyecto;

public interface IProyectoService {
  public List<Proyecto> verProyectos(Long id);

  public void crearProyecto(Proyecto proyecto, Long id);

  public void modificarProyecto(Proyecto proyecto, Long idPer, Long idPro);

  public void borrarProyecto(Long id);

  public Proyecto buscarProyecto(Long id);
}
