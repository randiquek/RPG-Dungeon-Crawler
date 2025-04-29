package com.myprojects.dungeonscape.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int monsterId;
    private String monsterName;
    private int level;
    private int monsterHp;
    private int attack;
    private int xpReward;
}
