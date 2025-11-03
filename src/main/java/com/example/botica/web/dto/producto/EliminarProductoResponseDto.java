package com.example.botica.web.dto.producto;

import com.example.botica.web.dto.item.ItemDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EliminarProductoResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private ProductoDto producto;
    private List<ItemDto> items_eliminados;
    private Integer total_items_eliminados;
    private String mensaje;

    public EliminarProductoResponseDto() { }

    public ProductoDto getProducto() { return producto; }
    public void setProducto(ProductoDto producto) { this.producto = producto; }

    public List<ItemDto> getItems_eliminados() { return items_eliminados; }
    public void setItems_eliminados(List<ItemDto> items_eliminados) { this.items_eliminados = items_eliminados; }

    public Integer getTotal_items_eliminados() { return total_items_eliminados; }
    public void setTotal_items_eliminados(Integer total_items_eliminados) { this.total_items_eliminados = total_items_eliminados; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
