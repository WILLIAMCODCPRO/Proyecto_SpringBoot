package com.s1.gestion_producto.service.impl;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.mapper.DetalleVentaMapper;
import com.s1.gestion_producto.mapper.ProductoMapper;
import com.s1.gestion_producto.mapper.VentaMapper;
import com.s1.gestion_producto.model.DetalleVenta;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import com.s1.gestion_producto.repository.DetalleVentaRepository;
import com.s1.gestion_producto.repository.ProductoRepository;
import com.s1.gestion_producto.repository.VentaRepository;
import com.s1.gestion_producto.service.DetalleVentaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleVentaServicelmpl implements DetalleVentaService {
    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;
    private final DetalleVentaMapper detalleVentaMapper;
    private final DetalleVentaRepository detalleVentaRepository;
    private final VentaMapper ventaMapper;
    private final VentaRepository ventaRepository;


    @Override
    public DetalleVentaResponseDTO guardarProducto(DetalleVentaRequestDTO dto) {
        Producto p = productoRepository.findById(dto.productoId()).orElseThrow(()->new EntityNotFoundException("eRROR NO EXISTE DICO producto"));
        Venta v = ventaRepository.findById(dto.ventaId()).orElseThrow(() -> new EntityNotFoundException("Error no existe dicha venta"));
        DetalleVenta dv = detalleVentaMapper.DTOAEntidad(dto,p,v);
        DetalleVenta dv_insertada = detalleVentaRepository.save(dv);
        ProductoResponseDTO dtoProducto =productoMapper.entidadADTO(p);
        VentaResponseDTO dtoVenta =ventaMapper.entidadADTO(v);
        return detalleVentaMapper.entidadADTO(dv_insertada, dtoProducto,dtoVenta);
    }

    @Override
    public DetalleVentaResponseDTO actualizarProducto(DetalleVentaRequestDTO dto, Long id) {
       DetalleVenta dv = detalleVentaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No existe"));
       Producto p = productoRepository.findById(dto.productoId()).orElseThrow(()->new  EntityNotFoundException("eRROR NO EXISTE DICO producto"));
       Venta v = ventaRepository.findById(dto.ventaId()).orElseThrow(() -> new EntityNotFoundException("Error no existe dicha venta"));
       detalleVentaMapper.actualizarEntidadDesdeDTO(dv,dto,p,v);
       DetalleVenta dv_actualizada = detalleVentaRepository.save(dv);
       ProductoResponseDTO dtoProducto = productoMapper.entidadADTO(p);
       VentaResponseDTO dtoVenta = ventaMapper.entidadADTO(v);
       return detalleVentaMapper.entidadADTO(dv_actualizada,dtoProducto,dtoVenta);
    }

    @Override
    public List<DetalleVentaResponseDTO> buscarTodos() {
        return detalleVentaRepository.findAll().stream().map(
                dato -> detalleVentaMapper.entidadADTO(dato,productoMapper.entidadADTO(productoRepository.findById(dato.getProducto().getId()).orElseThrow(()->new EntityNotFoundException("No existe el producto"))), ventaMapper.entidadADTO(ventaRepository.findById(dato.getVenta().getId()).orElseThrow(()->new EntityNotFoundException("No existe el producto"))))).toList();
    }

    @Override
    public DetalleVentaResponseDTO buscarPorId(Long id) {
        DetalleVenta dt = detalleVentaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No existe venta"));
        Producto producto = productoRepository.findById(dt.getProducto().getId()).orElseThrow(()->new EntityNotFoundException("no existe el producto"));
        ProductoResponseDTO productoR = productoMapper.entidadADTO(producto);
        Venta venta = ventaRepository.findById(dt.getVenta().getId()).orElseThrow(()->new EntityNotFoundException("no existe la venta"));
        VentaResponseDTO ventaR = ventaMapper.entidadADTO(venta);
        return detalleVentaMapper.entidadADTO(dt,productoR,ventaR);
    }

    @Override
    public void eliminarDetalle(Long id) {
        DetalleVenta dv= detalleVentaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No existe dicha venta a eliminar"));
        detalleVentaRepository.delete(dv);
    }
}
