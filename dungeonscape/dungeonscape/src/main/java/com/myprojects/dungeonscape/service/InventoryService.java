package com.myprojects.dungeonscape.service;

import com.myprojects.dungeonscape.data.model.Inventory;
import com.myprojects.dungeonscape.data.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(int inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(int inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
