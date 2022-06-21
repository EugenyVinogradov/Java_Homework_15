package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@Data

public class Game implements Map<String, Player> {
    protected HashMap<String, Player> game;

    public Game() {
        this.game = new HashMap<>();
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


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Player get(Object key) {
        return null;
    }

    @Override
    public Player put(String key, Player value) {
        return null;
    }

    @Override
    public Player remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Player> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Player> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Player>> entrySet() {
        return null;
    }
}
