package com.s1.gestion_producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @Schema(description = "Nombre del producto", example = "Cocacola")
        @NotNull(message = "Error, el nombre no puede ser nulo")
        @Size(min = 2, max = 25, message = "Error, el nombre debe tener minimo 2 caracteres maximo 25")
        String nombre,

        @Schema(description = "Lo que vale el producto", example = "100000")
        @NotNull(message = "Error, el precio no puede ser nulo")
        @Positive(message = "Error, el precio debe ser positivo")
        BigDecimal precio,

        @Schema(description = "Cantidad disponible del producto", example = "20")
        @NotNull(message = "Error, el stock no puede ser nulo")
        @Positive(message = "Error, el stock debe ser positivo")
        Long stock
) {
}
