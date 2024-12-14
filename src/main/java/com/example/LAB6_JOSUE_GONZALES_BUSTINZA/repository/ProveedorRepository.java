package com.example.LAB6_JOSUE_GONZALES_BUSTINZA.repository;

import com.example.LAB6_JOSUE_GONZALES_BUSTINZA.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype. Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}
