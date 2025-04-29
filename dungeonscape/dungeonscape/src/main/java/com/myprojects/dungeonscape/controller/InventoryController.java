package com.myprojects.dungeonscape.controller;

import com.myprojects.dungeonscape.data.model.Inventory;
import com.myprojects.dungeonscape.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public Inventory addInventoryItem(@RequestBody Inventory inventory) {
        return inventoryService.addInventoryItem(inventory);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable int id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable int id, @RequestBody Inventory updatedInventory) {
        updatedInventory.setInventoryId(id);
        return inventoryService.updateInventory(updatedInventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
    }
}
