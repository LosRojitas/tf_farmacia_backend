package com.example.botica.Controller;

import com.example.botica.Service.CategoriaService;
import com.example.botica.web.dto.categoria.CategoriaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/guardarcategoria")
    public String guardarCategoria(@RequestParam String tipo_categoria,
                                   @RequestParam String descripcion_categoria) {
        return categoriaService.guardarCategoria(tipo_categoria, descripcion_categoria);
    }

    @GetMapping("/listarcategoria")
    public List<CategoriaDto> listarCategoria() {
        return categoriaService.listarCategorias();
    }
}
