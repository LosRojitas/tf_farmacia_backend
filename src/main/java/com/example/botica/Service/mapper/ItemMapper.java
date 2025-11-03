package com.example.botica.Service.mapper;

import com.example.botica.Model.Item;
import com.example.botica.web.dto.item.ItemDto;

public final class ItemMapper {

    private ItemMapper() { }

    public static ItemDto toDto(Item i) {
        if (i == null) return null;
        return new ItemDto(
                i.getId(),
                i.getFecha_registro(),
                i.getCantidad_item(),
                ProductoMapper.toDto(i.getProducto()), // delega
                i.getFecha_vencimiento(),
                UsuarioMapper.toDto(i.getUsuario())    // delega
        );
    }
}
