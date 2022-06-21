package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@Data

public class Game implements List<Player> {
    protected ArrayList<Player> game;

    public Game() {
        this.game = new ArrayList<>();
    }


    public Player findByName(String playerName) {
        for(Player player : game) {
            if(player.getName() == playerName) {
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
        if (findByName(playerName1) != null){
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
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Player> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Player player) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Player> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Player> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Player get(int index) {
        return null;
    }

    @Override
    public Player set(int index, Player element) {
        return null;
    }

    @Override
    public void add(int index, Player element) {

    }

    @Override
    public Player remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Player> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Player> listIterator(int index) {
        return null;
    }

    @Override
    public List<Player> subList(int fromIndex, int toIndex) {
        return null;
    }
}
