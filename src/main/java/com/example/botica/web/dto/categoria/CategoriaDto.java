package com.example.botica.web.dto.categoria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.botica.Model.Categoria}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tipo_categoria;
    private String descripcion_categoria;

    public CategoriaDto() {

    }

    public CategoriaDto(Long id, String tipo_categoria, String descripcion_categoria) {
        this.id = id;
        this.tipo_categoria = tipo_categoria;
        this.descripcion_categoria = descripcion_categoria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo_categoria() { return tipo_categoria; }
    public void setTipo_categoria(String tipo_categoria) { this.tipo_categoria = tipo_categoria; }

    public String getDescripcion_categoria() { return descripcion_categoria; }
    public void setDescripcion_categoria(String descripcion_categoria) { this.descripcion_categoria = descripcion_categoria; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaDto that = (CategoriaDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tipo_categoria, that.tipo_categoria) &&
                Objects.equals(descripcion_categoria, that.descripcion_categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo_categoria, descripcion_categoria);
    }

    @Override
    public String toString() {
        return "CategoriaDto(" +
                "id=" + id +
                ", tipo_categoria=" + tipo_categoria +
                ", descripcion_categoria=" + descripcion_categoria +
                ')';
    }
}
