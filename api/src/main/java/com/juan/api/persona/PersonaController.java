package com.juan.api.persona;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/personas")
public class PersonaController {

    private final PersonaService personaService;
    @Autowired
    public PersonaController (PersonaService personaService){
        this.personaService=personaService;
    }
    

    //1.1 Mostrar personas de la base de datos
	@GetMapping
    public List<Persona> getPersonas(){

        return this.personaService.getPersonas();
    }

//  1. Crear persona en la tabla persona

//  1.1 Crear Persona
//  Peticion Post:
//  http://127.0.0.1:8080/api/v1/personas

 // Body
    
//  {
//     "nombre": "Andres",
//     "edad": 30,
//     "ocupacion": "Modelo"
//   }


    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }
}
