package com.s1.gestion_producto.controller;


import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.service.impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Producto", description = "Procesa todo lo relacionado a Producto")
@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
@Validated

public class ProductoController {
    private final ProductoServiceImpl ProductoService;

    @Operation(summary = "Permite Guarda los Productos", description = "Guarda los productos  en la base de datos")
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Poducto creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid  @Parameter(description = " Porudcto aguardar") @RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoService.guardarProducto(dto));
    }

    @Operation(summary = "Permite Actualizar los Productos", description = "Actualizar los productos  en la base de datos")
    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Producto actualizado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado")
            }
    )
    public ResponseEntity<ProductoResponseDTO> actualizar(@Valid @Parameter(description = "Id de Producto a actualizar", example = "1") @RequestBody ProductoRequestDTO dto,@PathVariable Long id){
        return ResponseEntity.ok().body(ProductoService.actualizarProducto(dto,id));
    }

    @Operation(summary = "Permite listar los Productos", description = "Listar los productos  en la base de datos")
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(ProductoService.buscarTodos());
    }

    @Operation(summary = "Permite buscar por id los Productos", description = "buscar por id los productos  en la base de datos")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarId(@Valid @Parameter(description = "Id de Producto a buscar", example = "1") @PathVariable Long id){
        return ResponseEntity.ok().body(ProductoService.buscarPorId(id));
    }

    @Operation(summary = "Permite eliminar por id los Productos", description = "Eliminar por id los productos  en la base de datos")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@Valid @Parameter(description = "Id de Producto a eliminar", example = "1") @PathVariable Long id){
        ProductoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
