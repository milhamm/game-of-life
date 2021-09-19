package dev.aang.gameoflife;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);
        game.addLivingCell(2, 0)
                .addLivingCell(2, 1)
                .addLivingCell(2, 2)
                .addLivingCell(1, 2)
                .addLivingCell(0, 1)
                .start();
    }
}
