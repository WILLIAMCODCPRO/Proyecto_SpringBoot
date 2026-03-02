package com.s1.gestion_producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(

        @Schema(description = "Poducto relacionado con detalle de venta", example = "Cocacola")
        Long productoId,

        @Schema(description = "Venta relacionado con detalle de venta", example = "1")
        Long ventaId,

        @Schema(description = "Cantidad del producto vendido", example = "100")
        Long cantidad,

        @Schema(description = "El total que se vendio", example = "100000")
        BigDecimal subtotal
) {
}
