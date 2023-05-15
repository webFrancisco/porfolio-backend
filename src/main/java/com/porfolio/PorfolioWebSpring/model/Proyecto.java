package com.porfolio.PorfolioWebSpring.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private String destino;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "persona_id")
  @JsonIgnore
  private Persona persona;

  public Proyecto() {
  }

  public Proyecto(Long id, String titulo, String destino, LocalDate fechaInicio, LocalDate fechaFin,
      String descripcion) {
    this.id = id;
    this.titulo = titulo;
    this.destino = destino;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.descripcion = descripcion;
  }
}