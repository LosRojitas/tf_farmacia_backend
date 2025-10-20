package com.example.botica.Service;

import com.example.botica.Model.Categoria;
import com.example.botica.Model.Producto;
import com.example.botica.Model.Item;
import com.example.botica.Model.Usuario;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Repository.ProductoRepository;
import com.example.botica.Repository.ItemRepository;
import com.example.botica.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public String guardarProducto(String nombre_producto, Long categoriaId, int cantidad, String procedencia, String fecha_vencimiento) {

        // 1) Validar/obtener categoría
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate vencimientoFormateado = LocalDate.parse(fecha_vencimiento, formatter);

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + categoriaId));

        Usuario usuario = usuarioRepository.findAll().stream().findFirst().orElse(null);
        LocalDate fecha_registro = LocalDate.now();
        // 2) Armar y guardar Producto
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre_producto(nombre_producto);
        nuevoProducto.setCategoria(categoria);
        nuevoProducto.setCantidad(cantidad);
        nuevoProducto.setProcedencia(procedencia);

        Producto productoGuardado = productoRepository.save(nuevoProducto);

        // 3) Crear Item automáticamente y asociarlo al producto recién creado
        Item itemAuto = new Item();
        itemAuto.setProducto(productoGuardado);
        itemAuto.setCantidad_item(cantidad);
        itemAuto.setFecha_registro(fecha_registro);
        itemAuto.setFecha_vencimiento(vencimientoFormateado);
        itemAuto.setUsuario(usuario);

        Item itemGuardado = itemRepository.save(itemAuto);

        return "Producto guardado (id=" + productoGuardado.getId()
                + ") y Item generado automáticamente (id=" + itemGuardado.getId() + ").";
    }
}
