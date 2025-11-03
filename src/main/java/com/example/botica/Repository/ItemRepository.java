package com.example.botica.Repository;

import com.example.botica.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    long deleteByProductoId(Long productoId);

    List<Item> findByProductoId(Long productoId);

    @Query("select coalesce(sum(i.cantidad_item), 0) from Item i where i.producto.id = :productoId")
    Integer sumaCantidadPorProducto(@Param("productoId") Long productoId);
}
