package com.example.botica.Service;

import com.example.botica.Model.Producto;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Repository.ItemRepository;
import com.example.botica.Repository.ProductoRepository;
import com.example.botica.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Producto guardarProducto(Producto producto){
        return null;
    }

}
