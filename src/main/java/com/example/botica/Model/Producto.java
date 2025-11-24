package com.example.botica.Model;

import javax.persistence.*;

@Entity //anotacion que marca esta clase como una entidad de db
public class Producto {

    @Id // anotacion que define ID como una primary key de la entidad producto.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el valor id se genera automaticamente
    private Long id;

    private String nombre_producto;

    @ManyToOne //anotacion que establece una relación de muchos productos a una categoría.
    private Categoria categoria;

    private int cantidad;
    private String procedencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
}
