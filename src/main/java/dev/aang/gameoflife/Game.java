package dev.aang.gameoflife;

public class Game {

    Grid grid = new Grid();

    public void start(){
        grid.setGridSize(20)
                .initializeGrid()
                .addLivingCell(2, 1)
                .addLivingCell(2, 2)
                .addLivingCell(2, 3)
                .addLivingCell(1, 3)
                .addLivingCell(0, 2)
                .displayGrid();

    }

    private void evolve(){
        System.out.println("Evolving Method");
    }

}
