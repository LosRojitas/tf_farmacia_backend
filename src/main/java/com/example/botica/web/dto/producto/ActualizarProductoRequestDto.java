package com.example.botica.web.dto.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualizarProductoRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre_producto;

    @NotNull(message = "La categoría es obligatoria")
    private Long categoria_id;

    @NotBlank(message = "La procedencia es obligatoria")
    private String procedencia;

    public ActualizarProductoRequestDto() { }

    public String getNombre_producto() { return nombre_producto; }
    public void setNombre_producto(String nombre_producto) { this.nombre_producto = nombre_producto; }

    public Long getCategoria_id() { return categoria_id; }
    public void setCategoria_id(Long categoria_id) { this.categoria_id = categoria_id; }

    public String getProcedencia() { return procedencia; }
    public void setProcedencia(String procedencia) { this.procedencia = procedencia; }
}
