package com.example.botica.web.dto.item;

import com.example.botica.web.dto.usuario.UsuarioDto;
import com.example.botica.web.dto.producto.ProductoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.example.botica.Model.Item}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate fecha_registro;
    private int cantidad_item;
    private ProductoDto producto;
    private LocalDate fecha_vencimiento;
    private UsuarioDto usuario;

    public ItemDto() { }

    public ItemDto(Long id,
                   LocalDate fecha_registro,
                   int cantidad_item,
                   ProductoDto producto,
                   LocalDate fecha_vencimiento,
                   UsuarioDto usuario) {
        this.id = id;
        this.fecha_registro = fecha_registro;
        this.cantidad_item = cantidad_item;
        this.producto = producto;
        this.fecha_vencimiento = fecha_vencimiento;
        this.usuario = usuario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha_registro() { return fecha_registro; }
    public void setFecha_registro(LocalDate fecha_registro) { this.fecha_registro = fecha_registro; }

    public int getCantidad_item() { return cantidad_item; }
    public void setCantidad_item(int cantidad_item) { this.cantidad_item = cantidad_item; }

    public ProductoDto getProducto() { return producto; }
    public void setProducto(ProductoDto producto) { this.producto = producto; }

    public LocalDate getFecha_vencimiento() { return fecha_vencimiento; }
    public void setFecha_vencimiento(LocalDate fecha_vencimiento) { this.fecha_vencimiento = fecha_vencimiento; }

    public UsuarioDto getUsuario() { return usuario; }
    public void setUsuario(UsuarioDto usuario) { this.usuario = usuario; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDto)) return false;
        ItemDto entity = (ItemDto) o;
        return cantidad_item == entity.cantidad_item &&
                Objects.equals(id, entity.id) &&
                Objects.equals(fecha_registro, entity.fecha_registro) &&
                Objects.equals(producto, entity.producto) &&
                Objects.equals(fecha_vencimiento, entity.fecha_vencimiento) &&
                Objects.equals(usuario, entity.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha_registro, cantidad_item, producto, fecha_vencimiento, usuario);
    }

    @Override
    public String toString() {
        return "ItemDto(" +
                "id=" + id +
                ", fecha_registro=" + fecha_registro +
                ", cantidad_item=" + cantidad_item +
                ", producto=" + (producto != null ? producto.getId() : null) +
                ", fecha_vencimiento=" + fecha_vencimiento +
                ", usuario=" + (usuario != null ? usuario.getId() : null) +
                ')';
    }
}