package com.myprojects.dungeonscape.service;

import com.myprojects.dungeonscape.data.model.Battle;
import com.myprojects.dungeonscape.data.repository.BattleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattleService {
    private final BattleRepository battleRepository;

    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public Battle createBattle(Battle battle) {
        return battleRepository.save(battle);
    }

    public List<Battle> getAllBattles() {
        return battleRepository.findAll();
    }

    public Optional<Battle> getBattleById(int battleId) {
        return battleRepository.findById(battleId);
    }

    public Battle updateBattle(Battle battle) {
        return battleRepository.save(battle);
    }

    public void deleteBattle(int battleId) {
        battleRepository.deleteById(battleId);
    }
}
