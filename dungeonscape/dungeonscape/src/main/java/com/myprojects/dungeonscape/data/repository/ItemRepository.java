package com.myprojects.dungeonscape.data.repository;

import com.myprojects.dungeonscape.data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
