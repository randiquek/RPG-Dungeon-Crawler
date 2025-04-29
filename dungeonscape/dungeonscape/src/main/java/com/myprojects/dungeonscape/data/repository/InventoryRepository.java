package com.myprojects.dungeonscape.data.repository;

import com.myprojects.dungeonscape.data.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
