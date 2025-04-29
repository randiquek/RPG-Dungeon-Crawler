package com.myprojects.dungeonscape.data.repository;

import com.myprojects.dungeonscape.data.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Integer> {
}
