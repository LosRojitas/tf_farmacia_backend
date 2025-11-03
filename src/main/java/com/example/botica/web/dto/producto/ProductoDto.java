package com.example.botica.web.dto.producto;

import com.example.botica.web.dto.categoria.CategoriaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.botica.Model.Producto}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre_producto;
    private CategoriaDto categoria;
    private int cantidad;
    private String procedencia;

    public ProductoDto() {

    }

    public ProductoDto(Long id, String nombre_producto, CategoriaDto categoria, int cantidad, String procedencia) {
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.procedencia = procedencia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre_producto() { return nombre_producto; }
    public void setNombre_producto(String nombre_producto) { this.nombre_producto = nombre_producto; }

    public CategoriaDto getCategoria() { return categoria; }
    public void setCategoria(CategoriaDto categoria) { this.categoria = categoria; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getProcedencia() { return procedencia; }
    public void setProcedencia(String procedencia) { this.procedencia = procedencia; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDto that = (ProductoDto) o;
        return cantidad == that.cantidad &&
                Objects.equals(id, that.id) &&
                Objects.equals(nombre_producto, that.nombre_producto) &&
                Objects.equals(categoria, that.categoria) &&
                Objects.equals(procedencia, that.procedencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre_producto, categoria, cantidad, procedencia);
    }

    @Override
    public String toString() {
        return "ProductoDto(" +
                "id=" + id +
                ", nombre_producto=" + nombre_producto +
                ", categoria=" + categoria +
                ", cantidad=" + cantidad +
                ", procedencia=" + procedencia +
                ')';
    }
}
