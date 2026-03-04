package com.s1.gestion_producto.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaResponseDTO(
        Long id,
        LocalDateTime fecha,

        @Schema(description = "Total de la venta", example = "1000000")
        BigDecimal total
) {
}
