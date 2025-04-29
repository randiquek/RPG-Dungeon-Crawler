package com.myprojects.dungeonscape.service;

import com.myprojects.dungeonscape.data.model.Item;
import com.myprojects.dungeonscape.data.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(int itemId) {
        return itemRepository.findById(itemId);
    }

    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(int itemId) {
        itemRepository.deleteById(itemId);
    }
}
