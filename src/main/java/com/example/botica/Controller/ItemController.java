package com.example.botica.Controller;

import com.example.botica.Service.ItemService;
import com.example.botica.web.dto.item.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/guardar_item")
    public ItemDto guardarItem(@RequestBody com.example.botica.Model.Item item) {
        // Mantengo el request como entidad para no romper el front actual
        // pero se devuelve DTO bbys.
        return itemService.guardarItem(item);
    }

    @GetMapping("/productos")
    public List<ItemDto> listarItems() {
        // Mantengo la ruta/name y devuelvo DTOs
        return itemService.listarItems();
    }
}
