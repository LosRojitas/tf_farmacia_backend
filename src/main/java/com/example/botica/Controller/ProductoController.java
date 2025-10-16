package com.example.botica.Controller;

import com.example.botica.Model.Item;
import com.example.botica.Model.Producto;
import com.example.botica.Repository.ItemRepository;
import com.example.botica.Repository.ProductoRepository;
import com.example.botica.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Guarda un nuevo producto y crea automáticamente un Item asociado.
     */
    @PostMapping("/guardarproducto")
    public String guardarProducto(@RequestParam String nombre_producto,
                                  @RequestParam Long categoriaId,
                                  @RequestParam int cantidad,
                                  @RequestParam String procedencia,
                                  @RequestParam String fecha_vencimiento
    )



    {
        return productoService.guardarProducto(nombre_producto, categoriaId, cantidad, procedencia, fecha_vencimiento);
    }

    /**
     * Lista todos los productos existentes.
     */
    @GetMapping("/listar")
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    /**
     * Endpoint de prueba: lista todos los Items para verificar si se creó el id_producto.
     */
    @GetMapping("/ver_items")
    public List<Item> verItems() {
        return itemRepository.findAll();
    }
}
