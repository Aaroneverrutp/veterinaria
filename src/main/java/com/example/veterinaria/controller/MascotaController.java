package com.example.veterinaria.controller;

import com.example.veterinaria.model.Mascota;
import com.example.veterinaria.service.MascotaServicie;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/mascota")
public class MascotaController {
    private final MascotaServicie mascotaServicie;

    public MascotaController (MascotaServicie mascotaServicie){
        this.mascotaServicie = mascotaServicie;
    }

    @GetMapping
    public List<Mascota> obtenerMascotas(){
        return mascotaServicie.listarTodas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorId(@PathVariable Integer id){
        return mascotaServicie.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearMascota(@RequestBody Mascota mascota){
        if(mascota.getNombre() == null || mascota.getNombre().isEmpty()){
            return ResponseEntity.badRequest().body("El campo nombre es obligatorio");
        }
        if(mascota.getEdad() == null){
            return ResponseEntity.badRequest().body("El campo edad es obligatorio");
        }
        if(mascota.getEspecie() == null || mascota.getEspecie().isEmpty()){
            return ResponseEntity.badRequest().body("El campo especie es obligatorio");
        }
        return ResponseEntity.ok(mascotaServicie.crearMascota(mascota));
    }
}
