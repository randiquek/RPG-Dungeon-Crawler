package com.myprojects.dungeonscape.service;

import com.myprojects.dungeonscape.data.model.Battle;
import com.myprojects.dungeonscape.data.model.Monster;
import com.myprojects.dungeonscape.data.model.Player;
import com.myprojects.dungeonscape.data.repository.BattleRepository;
import com.myprojects.dungeonscape.data.repository.MonsterRepository;
import com.myprojects.dungeonscape.data.repository.PlayerRepository;
import com.myprojects.dungeonscape.dto.BattleResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BattleService {
    private final BattleRepository battleRepository;
    private final PlayerRepository playerRepository;
    private final MonsterRepository monsterRepository;

    public BattleService(BattleRepository battleRepository, PlayerRepository playerRepository, MonsterRepository monsterRepository) {
        this.battleRepository = battleRepository;
        this.playerRepository = playerRepository;
        this.monsterRepository = monsterRepository;
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

    public BattleResult fight(UUID playerId, int monsterId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new RuntimeException("Monster not found"));

        int playerAttack = 5;
        int playerHp = player.getPlayerHp();
        int monsterHp = monster.getMonsterHp();

        monsterHp -= playerAttack;

        if (monsterHp <= 0) {
            player.setXp(player.getXp() + monster.getXpReward());
            player.setLevel(calculateLevel(player.getXp()));
            player.setPlayerHp(playerHp);

            Battle battle = new Battle();
            battle.setPlayer(player);
            battle.setMonster(monster);
            battle.setResult("WIN");
            battle.setTimestamp(LocalDateTime.now());
            battleRepository.save(battle);
            playerRepository.save(player);

            return new BattleResult("WIN", monster.getXpReward(), playerHp);
        } else {
            playerHp -= monster.getAttack();
            player.setPlayerHp(Math.max(playerHp, 0));

            String result = playerHp > 0 ? "WIN" : "LOSE";
            int xpEarned = playerHp > 0 ? monster.getXpReward() : 0;
            if (playerHp > 0) {
                player.setXp(player.getXp() + xpEarned);
                player.setLevel(calculateLevel(player.getXp()));
            }

            Battle battle = new Battle();
            battle.setPlayer(player);
            battle.setMonster(monster);
            battle.setResult(result);
            battle.setTimestamp(LocalDateTime.now());
            battleRepository.save(battle);
            playerRepository.save(player);

            return new BattleResult(result, xpEarned, playerHp);
        }
    }

    private int calculateLevel(int xp) {
        return (xp/100) + 1;
    }
}
