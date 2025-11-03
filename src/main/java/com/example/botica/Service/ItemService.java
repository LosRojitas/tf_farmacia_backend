package com.example.botica.Service;

import com.example.botica.Model.Item;
import com.example.botica.web.dto.item.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto guardarItem(Item item);
    List<ItemDto> listarItems();
}