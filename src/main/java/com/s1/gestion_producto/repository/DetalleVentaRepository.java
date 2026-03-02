package com.s1.gestion_producto.repository;

import com.s1.gestion_producto.model.DetalleVenta;
import com.s1.gestion_producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository  extends JpaRepository<DetalleVenta, Long> {

}
