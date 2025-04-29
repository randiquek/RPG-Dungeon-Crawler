package com.myprojects.dungeonscape.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BattleRequest {
    private UUID playerId;
    private int monsterId;
}
