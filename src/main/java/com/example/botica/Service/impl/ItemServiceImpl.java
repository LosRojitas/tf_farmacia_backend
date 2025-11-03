package com.example.botica.Service.impl;

import com.example.botica.Model.Categoria;
import com.example.botica.Model.Item;
import com.example.botica.Model.Producto;
import com.example.botica.Model.Usuario;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Repository.ItemRepository;
import com.example.botica.Repository.ProductoRepository;
import com.example.botica.Repository.UsuarioRepository;
import com.example.botica.Service.ItemService;
import com.example.botica.Service.mapper.ItemMapper;
import com.example.botica.web.dto.item.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository,
                           ProductoRepository productoRepository,
                           UsuarioRepository usuarioRepository,
                           CategoriaRepository categoriaRepository) {
        this.itemRepository = itemRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional
    public ItemDto guardarItem(Item item) {
        Usuario primerUsuario = usuarioRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No hay usuarios registrados"));

        Categoria categoria = item.getProducto() != null ? item.getProducto().getCategoria() : null;
        if (categoria != null) {
            if (categoria.getId() == null) {
                categoria = categoriaRepository.save(categoria);
            } else {
                categoria = categoriaRepository.findById(categoria.getId()).orElse(categoria);
            }
        }

        Producto producto = item.getProducto();
        if (producto == null) {
            throw new IllegalArgumentException("El item debe incluir un producto");
        }
        producto.setCategoria(categoria);
        if (producto.getId() == null) {
            producto = productoRepository.save(producto);
        } else {
            Producto existente = productoRepository.findById(producto.getId()).orElse(null);
            if (existente != null) {
                existente.setCategoria(categoria);
                if (producto.getNombre_producto() != null) existente.setNombre_producto(producto.getNombre_producto());
                if (producto.getProcedencia() != null) existente.setProcedencia(producto.getProcedencia());
                existente.setCantidad(producto.getCantidad());
                producto = productoRepository.save(existente);
            } else {
                producto = productoRepository.save(producto);
            }
        }

        item.setUsuario(primerUsuario);
        item.setProducto(producto);

        Item guardado = itemRepository.save(item);

        return ItemMapper.toDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> listarItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> salida = new ArrayList<ItemDto>(items.size());
        for (Item i : items) {
            salida.add(ItemMapper.toDto(i));
        }
        return salida;
    }
}
