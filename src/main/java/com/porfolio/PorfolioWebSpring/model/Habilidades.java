package com.porfolio.PorfolioWebSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Habilidades {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nombre;
  private Short nivel;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id")
  @JsonIgnore
  private Persona persona;

  public Habilidades() {
  }

  public Habilidades(Long id, String nombre, Short nivel) {
    this.id = id;
    this.nombre = nombre;
    this.nivel = nivel;
  }
}