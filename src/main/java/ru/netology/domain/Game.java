package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.*;

@AllArgsConstructor
@Data

public class Game {
    protected HashMap<String,Player> game;

    public Game() {
        this.game = new HashMap<String, Player>();
    }


    public Player findByName(String playerName) {

        if (game.containsKey(playerName)) {
            return game.get(playerName);
        }

        return null;
    }


    public void register(Player player) {
        this.game.put(player.getName(), player);
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
