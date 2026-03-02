package com.s1.gestion_producto.service;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;

import java.util.List;

public interface  VentaService {
    VentaResponseDTO guardarVenta(VentaRequestDTO dto);
    VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id);
    List<VentaResponseDTO> buscarTodos();
    VentaResponseDTO buscarPorId(Long id);
    void eliminarVenta(Long id);
}
