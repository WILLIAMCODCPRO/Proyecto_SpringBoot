package com.s1.gestion_producto.service.impl;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.mapper.ProductoMapper;
import com.s1.gestion_producto.mapper.VentaMapper;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import com.s1.gestion_producto.repository.VentaRepository;
import com.s1.gestion_producto.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServicelmpl implements VentaService {
    private final VentaMapper ventaMapper;
    private final VentaRepository ventaRepository;

    @Override
    public VentaResponseDTO guardarVenta(VentaRequestDTO dto) {
        Venta v = ventaMapper.DTOAEntidad(dto);
        Venta v_insertado = ventaRepository.save(v);
        return ventaMapper.entidadADTO(v_insertado);
    }

    @Override
    public VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id) {
        Venta v = ventaRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha venta"));
        ventaMapper.actualizarEntidadDesdeDTO(v,dto);
        Venta v_actualizada = ventaRepository.save(v);
        return ventaMapper.entidadADTO(v_actualizada);
    }

    @Override
    public List<VentaResponseDTO> buscarTodos() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream().map(ventaMapper::entidadADTO).toList();
    }

    @Override
    public VentaResponseDTO buscarPorId(Long id) {
        Venta v = ventaRepository.findById(id).orElseThrow(()-> new RuntimeException("No existe dicha venta"));
        return ventaMapper.entidadADTO(v);
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta v = ventaRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha venta a eliminar"));
        ventaRepository.delete(v);
    }
}
