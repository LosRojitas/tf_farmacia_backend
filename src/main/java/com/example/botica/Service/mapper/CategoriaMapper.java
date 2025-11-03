package com.example.botica.Service.mapper;

import com.example.botica.Model.Categoria;
import com.example.botica.web.dto.categoria.CategoriaDto;

public final class CategoriaMapper {

    private CategoriaMapper() { }

    public static CategoriaDto toDto(Categoria c) {
        if (c == null) return null;
        return new CategoriaDto(
                c.getId(),
                c.getTipo_categoria(),
                c.getDescripcion_categoria()
        );
    }
}
