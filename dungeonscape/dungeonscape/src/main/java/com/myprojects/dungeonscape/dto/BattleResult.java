package com.myprojects.dungeonscape.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BattleResult {
    private String result;
    private int xpGained;
    private int playerRemainingHp;
}
