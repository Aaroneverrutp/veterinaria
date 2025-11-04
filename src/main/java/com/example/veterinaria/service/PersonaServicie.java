package com.example.veterinaria.service;

import com.example.veterinaria.model.Persona;
import com.example.veterinaria.repository.PersonaRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonaServicie {
    private final PersonaRepository personaRepository;

    public PersonaServicie(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    //Listar todas las persona
    public List<Persona> listarTodas(){
        return personaRepository.findAll();
    }

    //obtener persona por id
    public Optional<Persona> buscarPorId(Integer id){
        return personaRepository.findById(id);

    }

    //crear persona
    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    //Actualizar persona
    public Persona actualizarPersona(Integer id, Persona persona){
        persona.setId(id);
        return personaRepository.save(persona);
    }

    //Eliminar persona
    public void eliminarPersona (Integer id){
        personaRepository.deleteById(id);
    }
}
