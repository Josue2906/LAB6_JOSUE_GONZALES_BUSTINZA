package com.example.LAB6_JOSUE_GONZALES_BUSTINZA.controller;

import com.example.LAB6_JOSUE_GONZALES_BUSTINZA.model.Proveedor;
import com.example.LAB6_JOSUE_GONZALES_BUSTINZA.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
    private final ProveedorService service;
    
     // Constructor para inyectar el servicio
    public ProveedorController(ProveedorService service) {
        this.service = service;
    }
    
    // Mostrar todos los proveedores
    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", service.listarTodos());
        return "proveedores"; // Vista que muestra todos los proveedores
    }
    
    // Mostrar el formulario para crear un nuevo proveedor
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "formularioProveedor"; // Vista para el formulario de nuevo proveedor
    }
    
    // Guardar un nuevo proveedor
    @PostMapping
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        service.guardar(proveedor);
        return "redirect:/proveedores"; // Redirigir a la lista de proveedores después de guardar
    }
    
    // Mostrar el formulario para editar un proveedor existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("proveedor", service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id)));
        return "formularioProveedor"; // Vista para el formulario de edición de proveedor
    }
    
    // Eliminar un proveedor por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/proveedores"; // Redirigir a la lista de proveedores después de eliminar
    }
}
