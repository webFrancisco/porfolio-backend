package com.porfolio.PorfolioWebSpring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String acercaDe;
    private String enlaceGithub;
    private String enlaceLinkedin;
    private String titulo;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Experiencia> experiencias = new ArrayList<>();

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String acercaDe, String enlaceGithub, String enlaceLinkedin,
            String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDe = acercaDe;
        this.enlaceGithub = enlaceGithub;
        this.enlaceLinkedin = enlaceLinkedin;
        this.titulo = titulo;
    }
}
