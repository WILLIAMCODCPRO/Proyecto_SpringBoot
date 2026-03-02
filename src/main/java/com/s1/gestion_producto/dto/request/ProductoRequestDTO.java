package com.s1.gestion_producto.dto.request;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        String nombre,
        BigDecimal precio,
        Long stock
) {
}
