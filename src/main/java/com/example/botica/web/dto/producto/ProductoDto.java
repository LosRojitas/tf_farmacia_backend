package com.example.botica.web.dto.producto;

import com.example.botica.web.dto.categoria.CategoriaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; //anotacion por si el JSON contiene un campo que no está definido
// en el ProductoDto, no causará errores y será ignorado.

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable; //mplementar Serializable permite que la clase ProductoDto sea serializada y deserializada
import java.util.Objects; //proporciona métodos estáticos útiles, como equals(), hashCode() y toString(), que se usan
// para comparar objetos, generar códigos hash o generar una representación de texto del objeto.

/**
 * DTO for {@link com.example.botica.Model.Producto}
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // anotacion que le dice a Jackson que no incluya los valores null
// al serializar el objeto en JSON

@JsonIgnoreProperties(ignoreUnknown = true) //Anotacion que le india a Jackson que ignore cualquier propiedad del JSON
// que no esté presente en la clase ProductoDto
public class ProductoDto implements Serializable
{

    // Versión de la clase para la serialización. Asegura la compatibilidad al leer objetos guardados.
    private static final long serialVersionUID = 1L; //1 : un valor tipo L tipo Long para representar tipos de datos enteros grandes

    private Long id;
    private String nombre_producto;
    private CategoriaDto categoria;
    private int cantidad;
    private String procedencia;

    public ProductoDto()
    {

    }
    //constructor
    public ProductoDto(Long id,  String nombre_producto, CategoriaDto categoria, int cantidad, String procedencia) {
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
    public boolean equals(Object o) //Este método se utiliza para comparar si dos objetos son exactamente iguales,
    // y evitar que se agreguen duplicados porque ya existe uno.
    {
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
    public int hashCode() //Crea un código hash único para cada objeto basado en los valores de los atributos
    {
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
