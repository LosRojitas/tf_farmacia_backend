package com.example.botica.Service;

import com.example.botica.web.dto.usuario.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    String guardarUsuario(String nombre, String dni, String correo, String contrasenia);
    List<UsuarioDto> listarUsuarios();
}
