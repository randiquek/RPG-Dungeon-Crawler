package com.myprojects.dungeonscape.data.repository;

import com.myprojects.dungeonscape.data.model.Battle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleRepository extends JpaRepository<Battle, Integer> {
}
