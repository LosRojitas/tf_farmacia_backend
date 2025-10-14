package com.example.botica.Controller;

import com.example.botica.Model.Item;
import com.example.botica.Repository.ItemRepository;
import com.example.botica.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping ("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/guardar_item")
    public Item guardarItem(@RequestBody Item item) {
        return itemService.guardarItem(item);
    }

    @GetMapping("/productos")
    public List<Item> listarItems() {
        return itemRepository.findAll();
    }

}
