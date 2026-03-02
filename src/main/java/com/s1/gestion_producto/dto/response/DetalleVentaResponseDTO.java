package com.s1.gestion_producto.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(
        Long id,
        VentaResponseDTO ventaResponseDTO,
        ProductoResponseDTO productoResponseDTO,
        Long cantidad,
        BigDecimal subtotal

) {
}
