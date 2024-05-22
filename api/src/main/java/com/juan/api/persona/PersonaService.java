package com.juan.api.persona;
//1 Crear Persona
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public List<Persona> getPersonas() {
        return this.personaRepository.findAll();
    }

    //1.Crear Persona

    public Persona guardarPersona(Persona persona) {
        if (persona.getId_persona() != null) { // Verificar si el ID es nulo
            Optional<Persona> existingPersona = personaRepository.findById(persona.getId_persona());
            if (existingPersona.isPresent()) {
                throw new IllegalStateException("Ya existe la persona");
            }
        }

        return personaRepository.save(persona);
    }

    
}