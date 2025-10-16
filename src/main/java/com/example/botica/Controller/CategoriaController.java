package com.example.botica.Controller;


import com.example.botica.Model.Categoria;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;






    @PostMapping("/guardarcategoria")
    public String guardarCategoria(@RequestParam String tipo_categoria, @RequestParam String descripcion_categoria)
    {
        return categoriaService.guardarCategoria( tipo_categoria, descripcion_categoria);
    }







    @GetMapping("/listarcategoria")
    public List<Categoria> listarCategoria()
    {
        return categoriaRepository.findAll();
    }
}
