package com.example.botica.Controller;

import com.example.botica.Model.Producto;
import com.example.botica.Service.ProductoService;
import com.example.botica.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    // Si usas @GeneratedValue en Producto.id, NO envíes "id" aquí.
    @PostMapping("/guardarproducto")
    public String guardarProducto(@RequestParam String nombre_producto,
                                  @RequestParam Long categoriaId,
                                  @RequestParam int cantidad,
                                  @RequestParam String procedencia) {
        return productoService.guardarProducto(nombre_producto, categoriaId, cantidad, procedencia);
    }

    @GetMapping("/listarproducto")
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }
}
