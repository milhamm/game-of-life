package dev.aang.gameoflife;

public class Game {

    Grid grid = new Grid();

    public void start(){
        grid.setGridSize(20)
                .initializeGrid()
                .addLivingCell(2, 0)
                .addLivingCell(2, 1)
                .addLivingCell(2, 2)
                .addLivingCell(1, 2)
                .addLivingCell(0, 1)
                .displayGrid();

    }

    private void evolve(){
        System.out.println("Evolving Method");
    }
}
