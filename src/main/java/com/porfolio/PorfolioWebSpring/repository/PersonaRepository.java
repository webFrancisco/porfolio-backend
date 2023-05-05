package com.porfolio.PorfolioWebSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.PorfolioWebSpring.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
