package com.s1.gestion_producto.controller;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.service.DetalleVentaService;
import com.s1.gestion_producto.service.impl.DetalleVentaServicelmpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "DetalleVenta", description = "Procesa todo lo relacionado a DetalleVenta")
@RestController
@RequestMapping("/api/detalleventa")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaServicelmpl detalleVentaService;

    @Operation(summary = "Permite Guarda los dettalles de venta", description = "Guarda los detalles de venta en la base de datos")
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Detalle venta creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@Parameter(description = " Detalle de venta a guardar") @RequestBody DetalleVentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.guardarProducto(dto));
    }

    @Operation(summary = "Permite actualizar los dettalles de venta", description = "Actualiza los detalles de venta en la base de datos")
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Detalle venta creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<DetalleVentaResponseDTO> actualizar(@Parameter(description = "Id de Detalle de venta a actualizar", example = "1") @RequestBody DetalleVentaRequestDTO dto,@PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.actualizarProducto(dto,id));
    }

    @Operation(summary = "Permite listar los dettalles de venta", description = "Listar los detalles de venta de la base de datos")
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Detalle venta creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<List<DetalleVentaResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(detalleVentaService.buscarTodos());
    }

    @Operation(summary = "Permite buscar por id los dettalles de venta", description = "Buscar por id los detalles de venta en la base de datos")
    @GetMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Detalle venta creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<DetalleVentaResponseDTO> buscarId(@Parameter(description = "Id de Detalle de venta a buscar", example = "1") @PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.buscarPorId(id));
    }

    @Operation(summary = "Permite eliminar por id los dettalles de venta", description = "Eliminar por id los detalles de venta en la base de datos")
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Detalle venta creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<Void> eliminar(@Parameter(description = "Id de Detalle de venta a eliminar", example = "1") @PathVariable Long id){
        detalleVentaService.eliminarDetalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
