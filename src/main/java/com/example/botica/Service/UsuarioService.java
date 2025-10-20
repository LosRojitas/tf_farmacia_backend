package com.example.botica.Service;

import com.example.botica.Model.Usuario;
import com.example.botica.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String guardarUsuario(String nombre,  String dni, String correo, String contrasenia) {

        // Valida el correo
        if (!correo.endsWith("@gmail.com")) {
            return "Correo inválido";
        }

        // Crea y guarda el usuario
        Usuario usuario_nuevo = new Usuario();

        usuario_nuevo.setNombre(nombre);
        usuario_nuevo.setDni(dni);
        usuario_nuevo.setCorreo(correo);
        usuario_nuevo.setContrasenia(contrasenia);
        usuarioRepository.save(usuario_nuevo);

        return "Usuario guardado: " + correo;
    }
}
