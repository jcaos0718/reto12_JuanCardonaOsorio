package com.juan.api.lugar;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.juan.api.persona.Persona;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LugarService {
    private final LugarRepository lugarRepository;

    @Autowired
    public LugarService(LugarRepository lugarRepository) {
        this.lugarRepository = lugarRepository;
    }

    //3. Observar la tabla de lugar

    public List<Lugar> getLugares() {
        return this.lugarRepository.findAll();
    }

    //2. Crear lugar

    public Lugar newLugar(Lugar lugar) {
        Optional<Lugar> res = lugarRepository.findByNombre(lugar.getNombre());
        if (res.isPresent()) {
            Lugar lugarExistente = res.get();
            List<Persona> personasActuales = lugarExistente.getPersonas();
            personasActuales.addAll(lugar.getPersonas()); // Agregar todas las personas del nuevo lugar
            lugarExistente.setPersonas(personasActuales);
            return lugarRepository.save(lugarExistente);
        } else {
            return lugarRepository.save(lugar);
        }
    }

    //3. Consultar personas que hayan visitado un lugar especifico
    public List<Persona> getPersonasPorLugar(String nombreLugar) {
        Optional<Lugar> lugar = lugarRepository.findByNombre(nombreLugar);
        if (lugar.isPresent()) {
            return lugar.get().getPersonas();
        } else {
            return new ArrayList<>(); // Devuelve una lista vacía si el lugar no existe
        }
    }

   


    //4. Consultar lugares visitados de un país especifico
    public List<Lugar> getLugaresPorPais(String pais) {
        return lugarRepository.findByPais(pais);
    }

  

   

   

  
    
}