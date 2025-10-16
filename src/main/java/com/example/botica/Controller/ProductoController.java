package com.example.botica.Controller;

import com.example.botica.Model.Item;
import com.example.botica.Model.Producto;
import com.example.botica.Repository.ProductoRepository;
import com.example.botica.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;
    @Autowired
    private ProductoRepository ProductoRepository;

    @PostMapping("/guardar_producto")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return ProductoService.guardarProducto(producto);
    }


    @GetMapping("/listar")
    public List<Producto> listarProductos() {
        return ProductoRepository.findAll();
    }

}
