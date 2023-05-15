package com.porfolio.PorfolioWebSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.PorfolioWebSpring.model.Habilidades;
import com.porfolio.PorfolioWebSpring.model.Persona;

public interface HabilidadesRepository extends JpaRepository<Habilidades, Long> {
  List<Habilidades> findByPersona(Persona persona);
}
