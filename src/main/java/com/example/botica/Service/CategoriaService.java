package com.example.botica.Service;

import com.example.botica.web.dto.categoria.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    String guardarCategoria(String tipo_categoria, String descripcion_categoria);
    List<CategoriaDto> listarCategorias();
}
