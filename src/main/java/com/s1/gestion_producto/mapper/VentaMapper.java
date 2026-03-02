package com.s1.gestion_producto.mapper;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    public VentaResponseDTO entidadADTO(Venta venta){
        if(venta==null) return null;
        return new VentaResponseDTO(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal()
        );
    }

    public Venta DTOAEntidad(VentaRequestDTO dto){
        if(dto==null) return null;
        Venta v=new Venta();
        v.setFecha(dto.fecha());
        v.setTotal(dto.total());
        return v;
    }

    public void actualizarEntidadDesdeDTO(Venta v,VentaRequestDTO dto) {
        if (dto == null) return;
        v.setFecha(dto.fecha());
        v.setTotal(dto.total());
    }
}
