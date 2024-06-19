package com.veggy.backend.veggy_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.veggy.backend.veggy_backend.repository.ItemRepository;

import org.springframework.web.bind.annotation.GetMapping;

import com.veggy.backend.veggy_backend.helpers.GenericResponse;

import com.veggy.backend.veggy_backend.models.Item;

@RestController()
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public GenericResponse<List<Item>> getAll() {

        GenericResponse<List<Item>> itemResponse = new GenericResponse<>();
        itemResponse.setStatus("200");
        itemResponse.setMessage("Items retrieved successfully");
        itemResponse.setData(this.itemRepository.findAll());

        return itemResponse;
    }
}
