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
    private String email;
    private String password;
    private String acercaDe;
    private String enlaceGithub;
    private String enlaceLinkedin;
    private String titulo;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Experiencia> experiencias = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Formacion> formacion = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Habilidades> habilidades = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Proyecto> proyectos = new ArrayList<>();

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String email, String password, String acercaDe,
            String enlaceGithub, String enlaceLinkedin,
            String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.acercaDe = acercaDe;
        this.enlaceGithub = enlaceGithub;
        this.enlaceLinkedin = enlaceLinkedin;
        this.titulo = titulo;
    }
}
