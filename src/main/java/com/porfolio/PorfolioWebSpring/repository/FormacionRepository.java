package com.porfolio.PorfolioWebSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.PorfolioWebSpring.model.Formacion;
import com.porfolio.PorfolioWebSpring.model.Persona;

public interface FormacionRepository extends JpaRepository<Formacion, Long> {
  List<Formacion> findByPersona(Persona persona);
}
