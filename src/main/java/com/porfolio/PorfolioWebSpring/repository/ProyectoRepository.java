package com.porfolio.PorfolioWebSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.PorfolioWebSpring.model.Persona;
import com.porfolio.PorfolioWebSpring.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
  List<Proyecto> findByPersona(Persona persona);
}
