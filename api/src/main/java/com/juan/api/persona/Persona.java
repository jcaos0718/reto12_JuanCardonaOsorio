package com.juan.api.persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_generator")
    @SequenceGenerator(name="persona_generator", sequenceName = "persona_seq", allocationSize=1)
    @Column(name = "id_persona", updatable = false, nullable = false)
    private Long id_persona;

    private String nombre;
    private int edad;
    private String ocupacion;



    public Persona() {}

    public Persona(long id_persona, String nombre, int edad, String ocupacion) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
    }

    public Persona(String nombre, int edad, String ocupacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona= id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }


}