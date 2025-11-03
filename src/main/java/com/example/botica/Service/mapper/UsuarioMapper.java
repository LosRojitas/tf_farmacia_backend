package com.example.botica.Service.mapper;

import com.example.botica.Model.Usuario;
import com.example.botica.web.dto.usuario.UsuarioDto;

public final class UsuarioMapper {

    private UsuarioMapper() { }

    public static UsuarioDto toDto(Usuario u) {
        if (u == null) return null;
        return new UsuarioDto(
                u.getId(),
                u.getNombre(),
                u.getCorreo(),
                u.getDni()
        );
    }
}
