package com.example.veterinaria.controller;


import com.example.veterinaria.model.Persona;
import com.example.veterinaria.service.PersonaServicie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/persona")

public class PersonaController {
    private final PersonaServicie personaServicie;

    public PersonaController (PersonaServicie personaServicie){
        this.personaServicie = personaServicie;
    }

    @GetMapping
    public List<Persona> obtenerPersonas(){
        return personaServicie.listarTodas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Integer id){
        return personaServicie.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearMascota(@RequestBody Persona persona){
        if(persona.getNombre() == null || persona.getNombre().isEmpty()){
            return ResponseEntity.badRequest().body("El campo nombre es obligatorio");
        }
        if(persona.getApellido() == null || persona.getApellido().isEmpty()){
            return ResponseEntity.badRequest().body("El campo apellido es obligatorio");
        }
        if(persona.getDni() == null){
            return ResponseEntity.badRequest().body("El campo DNI es obligatorio");
        }

        if (persona.getTelefono() == null){
            return ResponseEntity.badRequest().body("El campo telefono es obligatorio");
        }
        return ResponseEntity.ok(personaServicie.crearPersona(persona));
    }
}
