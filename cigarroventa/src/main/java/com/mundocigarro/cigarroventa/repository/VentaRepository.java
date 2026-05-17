package com.mundocigarro.cigarroventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mundocigarro.cigarroventa.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
