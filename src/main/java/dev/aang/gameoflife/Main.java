package dev.aang.gameoflife;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(12);
        game.addPatterns(Patterns.BEACON).start();
    }
}
