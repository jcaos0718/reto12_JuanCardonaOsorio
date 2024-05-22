package com.juan.api.lugar;

import com.juan.api.persona.Persona;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lugar")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lugar;
    @Column(unique = true)
    private String nombre;
    private String departamento_o_estado;
    private String pais;

    @OneToMany
    @JoinColumn(name = "id_lugar")
    private List<Persona> personas;

    public Lugar() {}


    public Lugar(Long id_lugar, String nombre, String departamento_o_estado, String pais, List<Persona> personas) {
        this.id_lugar = id_lugar;
        this.nombre = nombre;
        this.departamento_o_estado = departamento_o_estado;
        this.pais = pais;
        this.personas = personas;
    }
 
    
    public Long getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(Long id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento_o_estado() {
        return departamento_o_estado;
    }

    public void setDepartamento_o_estado(String departamento_o_estado) {
        this.departamento_o_estado = departamento_o_estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
 

    
}