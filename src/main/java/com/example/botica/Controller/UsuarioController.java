package com.example.botica.Controller;

import com.example.botica.Model.Usuario;
import com.example.botica.Service.UsuarioService;
import com.example.botica.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/guardar")
    public String guardarUsuario(@RequestParam String nombre, @RequestParam String dni, @RequestParam String correo, @RequestParam String contrasenia) {
        return usuarioService.guardarUsuario(nombre, dni, correo, contrasenia);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
