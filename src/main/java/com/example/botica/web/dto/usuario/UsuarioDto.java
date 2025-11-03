package com.example.botica.web.dto.usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.botica.Model.Usuario}
 * Versión de salida (no expone contraseña).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String correo;
    private String dni;

    public UsuarioDto() { }

    public UsuarioDto(Long id, String nombre, String correo, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.dni = dni;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioDto)) return false;
        UsuarioDto that = (UsuarioDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, correo, dni);
    }

    @Override
    public String toString() {
        return "UsuarioDto(" +
                "id=" + id +
                ", nombre=" + nombre +
                ", correo=" + correo +
                ", dni=" + dni +
                ')';
    }
}