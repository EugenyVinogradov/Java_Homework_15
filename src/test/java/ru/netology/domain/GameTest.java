package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;


public class GameTest {
    public Game game = new Game();


    Player player1 = new Player(1, "Bob", 7);
    Player player2 = new Player(2, "Max", 6);
    Player player3 = new Player(3, "Alex", 8);
    Player player4 = new Player(4, "Pol", 5);
    Player newPlayer = new Player(5, "John", 6);


    @Test
    void checkRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(newPlayer);
        Collection expected = Arrays.asList(player1, player2, player3, player4, newPlayer);
        Collection actual = game.getGame();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void checkFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Player expected = player1;
        Player actual = game.findByName("Bob");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkRoundFirstPlayerWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 2;
        int actual = game.round("Bob", "Max");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkRoundSecondPlayerWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        int expected = 0;
        int actual = game.round("Pol", "Alex");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkRoundNobodyWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(newPlayer);
        int expected = 1;
        int actual = game.round("John", "Max");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkRoundWithFirstPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Vasya", "Bob"));
    }

    @Test
    void checkRoundWithSecondPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Alex", "Igor"));
    }


}
