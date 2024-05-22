package com.juan.api.lugar;

import java.util.List;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LugarRepository extends JpaRepository<Lugar,Long>{

     Optional<Lugar> findByNombre(String nombre);
     List<Lugar> findByPais(String pais);
     

}