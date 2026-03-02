package com.s1.gestion_producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @Schema(description = "Nombre del producto", example = "Cocacola")
        String nombre,

        @Schema(description = "Lo que vale el producto", example = "100000")
        BigDecimal precio,

        @Schema(description = "Cantidad disponible del producto", example = "20")
        Long stock
) {
}
