package com.s1.gestion_producto.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaResponseDTO(
        Long id,
        LocalDateTime fecha,
        BigDecimal total
) {
}
