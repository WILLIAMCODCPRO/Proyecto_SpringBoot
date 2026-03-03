package com.s1.gestion_producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaRequestDTO(

        @Schema(description = "Fecha en qeu se realizo la venta", example = "2026-03-02T17:31:30.841Z")
        LocalDateTime fecha,

        @Schema(description = "Total de la venta", example = "1000000")
        @Positive(message = "Error, el total debe ser positiva")
        BigDecimal total
) {
}
