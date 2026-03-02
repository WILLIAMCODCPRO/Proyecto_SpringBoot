package com.s1.gestion_producto.controller;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.service.VentaService;
import com.s1.gestion_producto.service.impl.VentaServicelmpl;
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
@Tag(name = "Venta", description = "Procesa todo lo relacionado a Venta")
@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
public class VentaController {

    private final VentaServicelmpl ventaService;

    @Operation(summary = "Permite guardar las Ventas", description = "Guardar las ventas  en la base de datos")
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Venta creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<VentaResponseDTO> guardar(@Parameter(description = "Venta a guardar") @RequestBody VentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.guardarVenta(dto));
    }

    @Operation(summary = "Permite actualizar las Ventas", description = "AActualizar las ventas  en la base de datos")
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Venta acyualizad exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<VentaResponseDTO> actualizar(@Parameter(description = "Id de Venta a actualizar", example = "1") @RequestBody VentaRequestDTO dto,@PathVariable Long id){
        return ResponseEntity.ok().body(ventaService.actualizarVenta(dto,id));
    }

    @Operation(summary = "Permite listar las Ventas", description = "Listar las ventas  en la base de datos")
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(ventaService.buscarTodos());
    }

    @Operation(summary = "Permite buscar por id las Ventas", description = "Buscar por id las ventas  en la base de datos")
    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> buscarId(@Parameter(description = "Id de Venta a buscar", example = "1") @PathVariable Long id){
        return ResponseEntity.ok().body(ventaService.buscarPorId(id));
    }

    @Operation(summary = "Permite eliminar por id las Ventas", description = "Eliminar por id las ventas  en la base de datos")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@Parameter(description = "Id de Venta a aceliminar", example = "1")@PathVariable Long id){
        ventaService.eliminarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
