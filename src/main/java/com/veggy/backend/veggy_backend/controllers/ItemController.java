package com.veggy.backend.veggy_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veggy.backend.veggy_backend.helpers.GenericResponse;
import com.veggy.backend.veggy_backend.models.Item;
import com.veggy.backend.veggy_backend.repository.ItemRepository;

@RestController()
@RequestMapping("/api/v1")
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public GenericResponse<List<Item>> getAll() {

        GenericResponse<List<Item>> itemResponse = new GenericResponse<>();
        itemResponse.setStatus(200);
        itemResponse.setMessage("Items retrieved successfully");
        itemResponse.setData(itemRepository.findAll());

        return itemResponse;
    }

    @GetMapping("/items/{id}")
    public GenericResponse<Optional<Item>> getById(@PathVariable Long id) {
        Optional<Item> getItem = itemRepository.findById(id);
        GenericResponse<Optional<Item>> itemResponse = new GenericResponse<>();

        if (getItem.isEmpty()) {
            itemResponse.setStatus(404);
            itemResponse.setMessage("Item not found");
            itemResponse.setData(null);

            return itemResponse;
        }

        itemResponse.setStatus(200);
        itemResponse.setMessage("Item retrieved successfully");
        itemResponse.setData(itemRepository.findById(id));

        return itemResponse;
    }

    @PostMapping(value = "/items", consumes = "application/json")
    public GenericResponse<Item> create(@RequestBody Item item) {
        GenericResponse<Item> itemResponse = new GenericResponse<>();
        itemResponse.setStatus(200);
        itemResponse.setMessage("Item created successfully");
        itemResponse.setData(this.itemRepository.save(item));

        return itemResponse;
    }

    @PutMapping(value = "/items/{id}", consumes = "application/json")
    public GenericResponse<Optional<Item>> update(@PathVariable Long id,
            @RequestBody Item item) {

        Optional<Item> getItem = itemRepository.findById(id);
        GenericResponse<Optional<Item>> itemResponse = new GenericResponse<>();

        if (getItem.isEmpty()) {
            itemResponse.setStatus(404);
            itemResponse.setMessage("Item not found");
            itemResponse.setData(null);

            return itemResponse;
        }

        itemResponse.setData(getItem.map(data -> {
            data.setTitle(item.getTitle());
            data.setDescription(item.getDescription());
            data.setPrice(item.getPrice());
            data.setQty(item.getQty());
            data.setImage(item.getImage());
            return itemRepository.save(data);
        }));
        itemResponse.setStatus(200);
        itemResponse.setMessage("Item updated successfully");

        return itemResponse;
    }

    @DeleteMapping("items/{id}")
    public GenericResponse<Optional<Item>> delete(@PathVariable Long id) {
        Optional<Item> getItem = itemRepository.findById(id);
        GenericResponse<Optional<Item>> itemResponse = new GenericResponse<>();

        if (getItem.isEmpty()) {
            itemResponse.setStatus(404);
            itemResponse.setMessage("Item not found");
            itemResponse.setData(null);

            return itemResponse;
        }
        itemRepository.deleteById(id);
        itemResponse.setData(null);
        itemResponse.setStatus(200);
        itemResponse.setMessage("Item deleted successfully");

        return itemResponse;

    }

}
