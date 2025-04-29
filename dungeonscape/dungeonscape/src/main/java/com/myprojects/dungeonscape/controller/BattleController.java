package com.myprojects.dungeonscape.controller;

import com.myprojects.dungeonscape.data.model.Battle;
import com.myprojects.dungeonscape.service.BattleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/battles")
public class BattleController {
    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping
    public Battle createBattle(@RequestBody Battle battle) {
        return battleService.createBattle(battle);
    }

    @GetMapping
    public List<Battle> getAllBattles() {
        return battleService.getAllBattles();
    }

    @GetMapping("/{id}")
    public Optional<Battle> getBattleById(@PathVariable int id) {
        return battleService.getBattleById(id);
    }

    @PutMapping("/{id}")
    public Battle updateBattle(@PathVariable int id, @RequestBody Battle updatedBattle) {
        updatedBattle.setBattleId(id);
        return battleService.updateBattle(updatedBattle);
    }

    @DeleteMapping("/{id}")
    public void deleteBattle(@PathVariable int id) {
        battleService.deleteBattle(id);
    }
}
