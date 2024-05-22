package com.juan.api.persona;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Buscar persona por id
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{
   
    Optional<Persona> findById(Long id_persona);

}
