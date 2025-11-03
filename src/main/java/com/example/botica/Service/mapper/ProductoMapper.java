package com.example.botica.Service.mapper;

import com.example.botica.Model.Producto;
import com.example.botica.web.dto.producto.ProductoDto;

public final class ProductoMapper {

    private ProductoMapper() { }

    public static ProductoDto toDto(Producto p) {
        if (p == null) return null;
        return new ProductoDto(
                p.getId(),
                p.getNombre_producto(),
                CategoriaMapper.toDto(p.getCategoria()),
                p.getCantidad(),
                p.getProcedencia()
        );
    }
}
