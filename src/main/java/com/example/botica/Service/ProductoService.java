package com.example.botica.Service;

import com.example.botica.Model.Categoria;
import com.example.botica.Model.Producto;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired private ProductoRepository productoRepository;
    @Autowired private CategoriaRepository categoriaRepository;

    public String guardarProducto(String nombre_producto, Long categoriaId, int cantidad, String procedencia)
    {
        Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + categoriaId));

        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre_producto(nombre_producto);
        nuevoProducto.setCategoria(categoria);
        nuevoProducto.setCantidad(cantidad);
        nuevoProducto.setProcedencia(procedencia);

        productoRepository.save( nuevoProducto);
        return "Producto guardado correctamente.";
    }


}
