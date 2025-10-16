package com.example.botica.Service;

import com.example.botica.Model.Categoria;
import com.example.botica.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public String guardarCategoria( String tipo_categoria, String descripcion_categoria) {

        Categoria categoria_nuevo = new Categoria();


        categoria_nuevo.setTipo_categoria(tipo_categoria);
        categoria_nuevo.setDescripcion_categoria(descripcion_categoria);
        categoriaRepository.save(categoria_nuevo);
        return "Categoría guardada correctamente.";
    }


}
