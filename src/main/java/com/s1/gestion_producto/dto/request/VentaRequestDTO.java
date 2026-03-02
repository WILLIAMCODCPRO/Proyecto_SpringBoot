package com.s1.gestion_producto.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaRequestDTO(
        LocalDateTime fecha,
        BigDecimal total
) {
}
