package com.example.botica.Service.impl;

import com.example.botica.Model.Categoria;
import com.example.botica.Model.Item;
import com.example.botica.Model.Producto;
import com.example.botica.Model.Usuario;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Repository.ItemRepository;
import com.example.botica.Repository.ProductoRepository;
import com.example.botica.Repository.UsuarioRepository;
import com.example.botica.Service.ProductoService;
import com.example.botica.Service.mapper.ProductoMapper;
import com.example.botica.web.dto.item.ItemDto;
import com.example.botica.web.dto.producto.ActualizarProductoRequestDto;
import com.example.botica.web.dto.producto.EliminarProductoResponseDto;
import com.example.botica.web.dto.producto.GuardarProductoResponseDto;
import com.example.botica.web.dto.producto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ItemRepository itemRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository,
                               CategoriaRepository categoriaRepository,
                               ItemRepository itemRepository,
                               UsuarioRepository usuarioRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.itemRepository = itemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public GuardarProductoResponseDto guardarProducto(String nombre_producto,
                                                      Long categoriaId,
                                                      int cantidad,
                                                      String procedencia,
                                                      String fecha_vencimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate vencimientoFormateado = LocalDate.parse(fecha_vencimiento, formatter);

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + categoriaId));

        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new IllegalStateException("No hay usuarios registrados.");
        }
        Usuario usuario = usuarios.get(0);

        LocalDate fecha_registro = LocalDate.now();

        // 1) Crear producto SIN tocar cantidad
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre_producto(nombre_producto);
        nuevoProducto.setCategoria(categoria);
        nuevoProducto.setProcedencia(procedencia);

        nuevoProducto.setCantidad(0);

        Producto productoGuardado = productoRepository.save(nuevoProducto);

        // 2) Crear el primer item (la cantidad recibida pertenece al item)
        Item itemAuto = new Item();
        itemAuto.setProducto(productoGuardado);
        itemAuto.setCantidad_item(cantidad);
        itemAuto.setFecha_registro(fecha_registro);
        itemAuto.setFecha_vencimiento(vencimientoFormateado);
        itemAuto.setUsuario(usuario);

        Item itemGuardado = itemRepository.save(itemAuto);

        // 3) Recalcular la cantidad del producto según sus items
        actualizarCantidadEnProducto(productoGuardado.getId());

        GuardarProductoResponseDto dto = new GuardarProductoResponseDto();
        dto.setProducto_id(productoGuardado.getId());
        dto.setItem_id(itemGuardado.getId());
        dto.setMensaje("Producto guardado e Item generado automáticamente");
        return dto;
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDto> respuesta = new ArrayList<>(productos.size());
        for (Producto p : productos) {
            respuesta.add(ProductoMapper.toDto(p));
        }
        return respuesta;
    }

    @Override
    @Transactional
    public ProductoDto actualizarProducto(Long id, ActualizarProductoRequestDto request) {
        // Cargar producto existente
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));

        // Resolver categoría
        Categoria categoria = categoriaRepository.findById(request.getCategoria_id())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + request.getCategoria_id()));

        // Actualizar SOLO campos editables por negocio
        producto.setNombre_producto(request.getNombre_producto());
        producto.setCategoria(categoria);
        producto.setProcedencia(request.getProcedencia());
        // No se toca la cantidad

        Producto actualizado = productoRepository.save(producto);

        // No hace falta recalcular la cantidad porque no se actualiza eso
        return ProductoMapper.toDto(actualizado);
    }

    @Override
    @Transactional
    public EliminarProductoResponseDto eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));

        List<Item> items = itemRepository.findByProductoId(id);

        List<ItemDto> itemsDto = new ArrayList<ItemDto>(items.size());
        for (Item it : items) {
            itemsDto.add(com.example.botica.Service.mapper.ItemMapper.toDto(it));
        }
        ProductoDto productoDto = ProductoMapper.toDto(producto);

        long borrados = itemRepository.deleteByProductoId(id);
        productoRepository.delete(producto);

        EliminarProductoResponseDto resp = new EliminarProductoResponseDto();
        resp.setProducto(productoDto);
        resp.setItems_eliminados(itemsDto);
        resp.setTotal_items_eliminados((int) borrados);
        resp.setMensaje("Producto e ítems asociados eliminados correctamente.");
        return resp;
    }

    private void actualizarCantidadEnProducto(Long productoId) {
        Integer total = itemRepository.sumaCantidadPorProducto(productoId);
        if (total == null) total = 0;

        Producto p = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + productoId));
        p.setCantidad(total.intValue());
        productoRepository.save(p);
    }
}
