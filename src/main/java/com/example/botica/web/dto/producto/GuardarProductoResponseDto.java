package com.example.botica.web.dto.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuardarProductoResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long producto_id;
    private Long item_id;
    private String mensaje;

    public GuardarProductoResponseDto() { }

    public GuardarProductoResponseDto(Long producto_id, Long item_id, String mensaje) {
        this.producto_id = producto_id;
        this.item_id = item_id;
        this.mensaje = mensaje;
    }

    public Long getProducto_id() { return producto_id; }
    public void setProducto_id(Long producto_id) { this.producto_id = producto_id; }

    public Long getItem_id() { return item_id; }
    public void setItem_id(Long item_id) { this.item_id = item_id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
