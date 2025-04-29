package com.myprojects.dungeonscape.data.repository;

import com.myprojects.dungeonscape.data.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
