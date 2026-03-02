package com.s1.gestion_producto.controller;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.service.DetalleVentaService;
import com.s1.gestion_producto.service.impl.DetalleVentaServicelmpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleventa")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaServicelmpl detalleVentaService;

    @PostMapping
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@RequestBody DetalleVentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.guardarProducto(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> actualizar(@RequestBody DetalleVentaRequestDTO dto,@PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.actualizarProducto(dto,id));
    }

    @GetMapping
    public ResponseEntity<List<DetalleVentaResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(detalleVentaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> buscarId(@PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        detalleVentaService.eliminarDetalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
