package com.porfolio.PorfolioWebSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.PorfolioWebSpring.model.Experiencia;
import com.porfolio.PorfolioWebSpring.model.Persona;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
  List<Experiencia> findByPersona(Persona persona);
}
