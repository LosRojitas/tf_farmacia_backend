package com.example.botica.Controller;


import com.example.botica.Model.Categoria;
import com.example.botica.Repository.CategoriaRepository;
import com.example.botica.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;






    @PostMapping("/guardarcategoria")
    public String guardarCategoria(@RequestParam Long categoria_id, @RequestParam String tipo_categoria, @RequestParam String descripcion_categoria)
    {
        return categoriaService.guardarCategoria(categoria_id, tipo_categoria, descripcion_categoria);
    }







    @GetMapping("/listarcategoria")
    public List<Categoria> listarCategoria()
    {
        return categoriaRepository.findAll();
    }
}
