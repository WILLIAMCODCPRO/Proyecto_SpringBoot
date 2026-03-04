package com.s1.gestion_producto.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(
        Long id,
        VentaResponseDTO venta,
        ProductoResponseDTO producto,
        Long cantidad,
        BigDecimal subtotal

) {
}
