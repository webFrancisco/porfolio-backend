package com.porfolio.PorfolioWebSpring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {
  private Long id;
  private String nombre;
  private String apellido;
  private String email;
  private String acercaDe;
  private String enlaceGithub;
  private String enlaceLinkedin;
  private String titulo;
}
