package com.s1.gestion_producto.mapper;


import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.model.DetalleVenta;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {

    public DetalleVentaResponseDTO entidadADTO(DetalleVenta detalleVenta, ProductoResponseDTO dto, VentaResponseDTO dto2){
        if(detalleVenta==null || dto == null || dto2 == null) return null;
        return new DetalleVentaResponseDTO(
                detalleVenta.getId(),
                dto2,
                dto,
                detalleVenta.getCantidad(),
                detalleVenta.getSubtotal()
        );
    }

    public DetalleVenta DTOAEntidad(DetalleVentaRequestDTO dto, Producto producto, Venta venta){
        if(dto==null || producto == null || venta == null) return null;
        DetalleVenta dV=new DetalleVenta();
        dV.setVenta(venta);
        dV.setProducto(producto);
        dV.setCantidad(dto.cantidad());
        dV.setSubtotal(dto.subtotal());
        return dV;
    }

    public void actualizarEntidadDesdeDTO(DetalleVenta dV,DetalleVentaRequestDTO dto, Producto producto, Venta venta) {
        if(dto==null || producto == null || venta == null) return;
        dV.setVenta(venta);
        dV.setProducto(producto);
        dV.setCantidad(dto.cantidad());
        dV.setSubtotal(dto.subtotal());
    }
}
