package com.example.botica.Controller;

import com.example.botica.Service.ProductoService;
import com.example.botica.web.dto.producto.ActualizarProductoRequestDto;
import com.example.botica.web.dto.producto.EliminarProductoResponseDto;
import com.example.botica.web.dto.producto.GuardarProductoResponseDto;
import com.example.botica.web.dto.producto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa las anotaciones necesarias para manejar las solicitudes HTTP en un controlador de Spring.

import javax.validation.Valid; // Importa la anotación @Valid para validar los objetos recibidos en las solicitudes.
import java.util.List;

@RestController  // Esta anotación indica que la clase es un controlador que maneja solicitudes REST
@RequestMapping("/producto")
@CrossOrigin(origins = "*")  // Permite solicitudes de cualquier origen
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardarproducto") // Define un método que maneja las solicitudes POST para guardar un nuevo producto.
    public GuardarProductoResponseDto guardarProducto(@RequestParam String nombre_producto,
                                                      @RequestParam Long categoriaId,
                                                      @RequestParam int cantidad,
                                                      @RequestParam String procedencia,
                                                      @RequestParam String fecha_vencimiento) {
        return productoService.guardarProducto(nombre_producto, categoriaId, cantidad, procedencia, fecha_vencimiento);
    }

    @PutMapping("/editar/{id}") // Define un método que maneja las solicitudes PUT para actualizar un producto existente
    public ProductoDto editarProducto(@PathVariable Long id,
                                      @RequestBody @Valid ActualizarProductoRequestDto body) {
        return productoService.actualizarProducto(id, body);
    }

    @DeleteMapping("/eliminar/{id}") // Define un método que maneja las solicitudes DELETE
    public EliminarProductoResponseDto eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

    @GetMapping("/listar") // Define un método que maneja las solicitudes GET para listar productos.
    public List<ProductoDto> listarProducto() {
        return productoService.listarProductos();
    }

}
