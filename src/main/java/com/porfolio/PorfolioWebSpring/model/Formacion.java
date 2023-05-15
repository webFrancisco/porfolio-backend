package com.porfolio.PorfolioWebSpring.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Formacion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String formacion;
  private String lugarFormacion;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String descripcionFormacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id")
  @JsonIgnore
  private Persona persona;

  public Formacion() {
  }

  public Formacion(Long id, String formacion, String lugarFormacion, LocalDate fechaInicio, LocalDate fechaFin,
      String descripcionFormacion) {
    this.id = id;
    this.formacion = formacion;
    this.lugarFormacion = lugarFormacion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.descripcionFormacion = descripcionFormacion;
  }
}