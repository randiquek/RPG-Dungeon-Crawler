package com.myprojects.dungeonscape.service;

import com.myprojects.dungeonscape.data.model.Monster;
import com.myprojects.dungeonscape.data.repository.MonsterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {
    private MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Monster createMonster(Monster monster) {
        return monsterRepository.save(monster);
    }

    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    public Optional<Monster> getMonsterById(int monsterId) {
        return monsterRepository.findById(monsterId);
    }

    public Monster updateMonster(Monster monster) {
        return monsterRepository.save(monster);
    }

    public void deleteMonster(int monsterId) {
        monsterRepository.deleteById(monsterId);
    }
}
