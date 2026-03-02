package com.s1.gestion_producto.service;



import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.model.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {
    DetalleVentaResponseDTO guardarProducto(DetalleVentaRequestDTO dto);
    DetalleVentaResponseDTO actualizarProducto(DetalleVentaRequestDTO dto, Long id);
    List<DetalleVentaResponseDTO> buscarTodos();
    DetalleVentaResponseDTO buscarPorId(Long id);
    void eliminarDetalle(Long id);
}
