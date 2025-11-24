package com.example.botica.Service;

import com.example.botica.web.dto.producto.ActualizarProductoRequestDto;
import com.example.botica.web.dto.producto.EliminarProductoResponseDto;
import com.example.botica.web.dto.producto.GuardarProductoResponseDto;
import com.example.botica.web.dto.producto.ProductoDto;

import java.util.List;

public interface ProductoService // Define la interfaz 'ProductoService'

{
    GuardarProductoResponseDto guardarProducto(String nombre_producto,//Define el método 'guardarProducto', que guarda
                                               // un nuevo producto en el sistema. Devuelve un DTO con la respuesta.
                                               Long categoriaId,
                                               int cantidad,
                                               String procedencia,
                                               String fecha_vencimiento);

    List<ProductoDto> listarProductos();

    ProductoDto actualizarProducto(Long id, ActualizarProductoRequestDto request);

    EliminarProductoResponseDto eliminarProducto(Long id);
}
