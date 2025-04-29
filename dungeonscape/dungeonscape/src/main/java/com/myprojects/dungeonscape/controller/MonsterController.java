package com.myprojects.dungeonscape.controller;

import com.myprojects.dungeonscape.data.model.Monster;
import com.myprojects.dungeonscape.service.MonsterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monsters")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @PostMapping
    public Monster createMonster(@RequestBody Monster monster) {
        return monsterService.createMonster(monster);
    }

    @GetMapping
    public List<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @GetMapping("/{id}")
    public Optional<Monster> getMonsterById(@PathVariable int id) {
        return monsterService.getMonsterById(id);
    }

    @PutMapping("/{id}")
    public Monster updateMonster(@PathVariable int id, @RequestBody Monster updatedMonster) {
        updatedMonster.setMonsterId(id);
        return monsterService.updateMonster(updatedMonster);
    }

    @DeleteMapping("/{id}")
    public void deleteMonster(@PathVariable int id) {
        monsterService.deleteMonster(id);
    }
}
