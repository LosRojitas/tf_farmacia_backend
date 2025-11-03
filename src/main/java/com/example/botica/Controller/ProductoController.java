package com.example.botica.Controller;

import com.example.botica.Service.ProductoService;
import com.example.botica.web.dto.producto.ActualizarProductoRequestDto;
import com.example.botica.web.dto.producto.EliminarProductoResponseDto;
import com.example.botica.web.dto.producto.GuardarProductoResponseDto;
import com.example.botica.web.dto.producto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardarproducto")
    public GuardarProductoResponseDto guardarProducto(@RequestParam String nombre_producto,
                                                      @RequestParam Long categoriaId,
                                                      @RequestParam int cantidad,
                                                      @RequestParam String procedencia,
                                                      @RequestParam String fecha_vencimiento) {
        return productoService.guardarProducto(nombre_producto, categoriaId, cantidad, procedencia, fecha_vencimiento);
    }

    @PutMapping("/editar/{id}")
    public ProductoDto editarProducto(@PathVariable Long id,
                                      @RequestBody @Valid ActualizarProductoRequestDto body) {
        return productoService.actualizarProducto(id, body);
    }

    @DeleteMapping("/eliminar/{id}")
    public EliminarProductoResponseDto eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

    @GetMapping("/listar")
    public List<ProductoDto> listarProducto() {
        return productoService.listarProductos();
    }

}
