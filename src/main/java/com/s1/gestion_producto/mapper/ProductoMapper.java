package com.s1.gestion_producto.mapper;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoResponseDTO entidadADTO(Producto producto){
        if(producto==null) return null;
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public Producto DTOAEntidad(ProductoRequestDTO dto){
        if(dto==null) return null;
        Producto p=new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        return p;
    }

    public void actualizarEntidadDesdeDTO(Producto p,ProductoRequestDTO dto) {
        if (dto == null) return;
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
    }
}
