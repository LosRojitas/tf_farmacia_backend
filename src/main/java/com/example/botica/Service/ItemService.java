package com.example.botica.Service;

import com.example.botica.Model.*;
import com.example.botica.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Item guardarItem(Item item) {

        //Obtener primer usuario y válidad que ya haya un usuario ingresado
        Usuario primer_usuario = usuarioRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No hay usuarios registrados"));

        // Guardar categoría
        Categoria categoria = item.getProducto().getCategoria();
        if (categoria.getId() == null) {
            categoria = categoriaRepository.save(categoria);
        }

        // Guardar producto
        Producto producto = item.getProducto();
        producto.setCategoria(categoria);
        if (producto.getId() == null) {
            producto = productoRepository.save(producto);
        }

        //Le indica que va con el primer usuario encontrado
        item.setUsuario(primer_usuario);
        item.setProducto(producto);

        return itemRepository.save(item);
    }
}