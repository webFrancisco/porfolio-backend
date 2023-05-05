package com.porfolio.PorfolioWebSpring.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String ocupacion;
  private String lugarOcupacion;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String descripcionOcupacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id")
  @JsonIgnore
  private Persona persona;

  public Experiencia() {
  }

  public Experiencia(Long id, String ocupacion, String lugarOcupacion, LocalDate fechaInicio, LocalDate fechaFin,
      String descripcionOcupacion) {
    this.id = id;
    this.ocupacion = ocupacion;
    this.lugarOcupacion = lugarOcupacion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.descripcionOcupacion = descripcionOcupacion;
  }
}