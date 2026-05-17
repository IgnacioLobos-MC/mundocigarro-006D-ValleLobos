package com.cigarro.inventariocigarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cigarro.inventariocigarro.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}
