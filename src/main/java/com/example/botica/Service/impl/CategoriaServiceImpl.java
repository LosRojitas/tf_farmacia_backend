package com.example.botica.Service.impl;

import com.example.botica.Model.Categoria;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Service.CategoriaService;
import com.example.botica.Service.mapper.CategoriaMapper;
import com.example.botica.web.dto.categoria.CategoriaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional
    public String guardarCategoria(String tipo_categoria, String descripcion_categoria) {

        Categoria categoria = new Categoria();
        categoria.setTipo_categoria(tipo_categoria);
        categoria.setDescripcion_categoria(descripcion_categoria);

        categoriaRepository.save(categoria);
        return "Categoría guardada correctamente.";
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDto> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaDto> salida = new ArrayList<>(categorias.size());
        for (Categoria c : categorias) {
            salida.add(CategoriaMapper.toDto(c));
        }
        return salida;
    }
}
