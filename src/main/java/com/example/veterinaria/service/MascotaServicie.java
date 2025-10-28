package com.example.veterinaria.service;
import com.example.veterinaria.model.Mascota;
import com.example.veterinaria.repository.MascotaRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MascotaServicie {
    private final MascotaRepository mascotaRepository;

    public MascotaServicie(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }

    //Listar todas las mascotas
    public List<Mascota> listarTodas(){
        return mascotaRepository.findAll();
    }

    //obtener mascota por id
    public Optional<Mascota> buscarPorId(Integer id){
        return mascotaRepository.findById(id);

    }

    //crear mascota
    public Mascota crearMascota(Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    //Actualizar mascota
    public Mascota actualizarMascota(Integer id, Mascota mascota){
        mascota.setId(id);
        return mascotaRepository.save(mascota);
    }

    //Eliminar mascota
    public void eliminarMascota (Integer id){
        mascotaRepository.deleteById(id);
    }
}
