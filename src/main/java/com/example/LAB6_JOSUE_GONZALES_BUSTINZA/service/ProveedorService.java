package com.example.LAB6_JOSUE_GONZALES_BUSTINZA.service;

import com.example.LAB6_JOSUE_GONZALES_BUSTINZA.model.Proveedor;
import com.example.LAB6_JOSUE_GONZALES_BUSTINZA.repository.ProveedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    // Listar todos los proveedores
    public List<Proveedor> listarTodos() {
        return repository.findAll();
    }
    
    // Guardar un proveedor
    public void guardar(Proveedor proveedor) {
        repository.save(proveedor);
    }
    
    // Buscar proveedor por su ID
    public Optional<Proveedor> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    // Eliminar un proveedor por su ID
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
