package com.example.botica.Service.impl;

import com.example.botica.Model.Usuario;
import com.example.botica.Repository.UsuarioRepository;
import com.example.botica.Service.UsuarioService;
import com.example.botica.Service.mapper.UsuarioMapper;
import com.example.botica.web.dto.usuario.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public String guardarUsuario(String nombre, String dni, String correo, String contrasenia) {
        if (correo == null || !correo.endsWith("@gmail.com")) {
            return "Correo inválido";
        }

        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setDni(dni);
        usuarioNuevo.setCorreo(correo);
        usuarioNuevo.setContrasenia(contrasenia);

        usuarioRepository.save(usuarioNuevo);

        return "Usuario guardado: " + correo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> salida = new ArrayList<>(usuarios.size());
        for (Usuario u : usuarios) {
            salida.add(UsuarioMapper.toDto(u));
        }
        return salida;
    }
}
