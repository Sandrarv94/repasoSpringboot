package com.example.mercancia.repositorios;

import com.example.mercancia.modelos.Mercancia;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia, Integer> {

}
