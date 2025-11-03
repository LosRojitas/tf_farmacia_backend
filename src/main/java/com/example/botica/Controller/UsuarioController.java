package com.example.botica.Controller;

import com.example.botica.Service.UsuarioService;
import com.example.botica.web.dto.usuario.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public String guardarUsuario(@RequestParam String nombre,
                                 @RequestParam String dni,
                                 @RequestParam String correo,
                                 @RequestParam String contrasenia) {
        return usuarioService.guardarUsuario(nombre, dni, correo, contrasenia);
    }

    @GetMapping("/listar")
    public List<UsuarioDto> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
