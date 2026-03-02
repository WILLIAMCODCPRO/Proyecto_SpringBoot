package com.s1.gestion_producto.service;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.model.Producto;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);
    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id);
    List<ProductoResponseDTO> buscarTodos();
    ProductoResponseDTO buscarPorId(Long id);
    void eliminarProducto(Long id);
}
