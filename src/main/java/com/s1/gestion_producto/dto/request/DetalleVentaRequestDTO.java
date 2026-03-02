package com.s1.gestion_producto.dto.request;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(
        Long productoId,
        Long ventaId,
        Long cantidad,
        BigDecimal subtotal
) {
}
