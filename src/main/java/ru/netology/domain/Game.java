package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.*;

@AllArgsConstructor
@Data

public class Game {
    protected ArrayList<Player> game;

    public Game() {
        this.game = new ArrayList<>();
    }


    public Player findByName(String playerName) {
        for (Player player : game) {
            if (player.getName().equals(playerName)) {
                Player tmp = player;
                return tmp;
            }
        }
        return null;
    }

    public void register(Player newPlayer) {
        this.game.add(newPlayer);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) != null) {
            if (findByName(playerName2) != null) {
                if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
                    return 2;
                }
                if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
                    return 1;
                }
                return 0;
            }
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");
        }
        throw new NotRegisteredException("Player " + playerName1 + " is not registered");
    }

}
