//2.Crear Lugar
package com.juan.api.lugar;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juan.api.persona.Persona;

@RestController
@RequestMapping(path="api/v1/lugares")
public class LugarController {

    private final LugarService lugarService;

    @Autowired
    public LugarController(LugarService lugarService) {
        this.lugarService = lugarService;
    }


    //2,1 Mostrarlugares
	@GetMapping
    public List<Lugar> getLugares(){

        return this.lugarService.getLugares();
    }


//  2.2 Crear Lugar
//  Peticion Post:
//  http://127.0.0.1:8080/api/v1/lugares

 // Body
    
//    {
//     "nombre": "Know",
//     "departamento_o_estado": "Madrid",
//     "pais": "España",
//     "personas": [
//        {
//          "id_persona": 2
//        }
//     ]
//   }
  
    @PostMapping
    public ResponseEntity<?> registrarLugar(@RequestBody Lugar lugar) {
        try {
            Lugar nuevoLugar = lugarService.newLugar(lugar);
            return new ResponseEntity<>(nuevoLugar, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el lugar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //3.Consultar personas que hayan visitado un lugar especifico
    //http://localhost:8080/api/v1/lugares/personasPorLugar?nombreLugar=Bogota
    @GetMapping("/personasPorLugar")
    public List<Persona> getPersonasPorLugar(@RequestParam String nombreLugar) {
        return this.lugarService.getPersonasPorLugar(nombreLugar);
    }


    //4.Consultar lugares visitados de un país especifico
    //http://localhost:8080/api/v1/lugares/por-pais/Italia
    @GetMapping("/por-pais/{pais}")
    public ResponseEntity<List<Lugar>> getLugaresPorPais(@PathVariable String pais) {
        List<Lugar> lugares = lugarService.getLugaresPorPais(pais);
        if (lugares.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lugares);
        }
    }
     
}
