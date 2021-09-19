package dev.aang.gameoflife;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(38);
        game.addPattern(PatternName.GLIDER_GUN).start();
    }
}
