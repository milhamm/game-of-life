package dev.aang.gameoflife;

public class Game {

    Grid grid;

    public void start(){
        grid = new Grid();
        grid.setGridSize(20).displayGrid();

    }

    private void evolve(){
        System.out.println("Evolving Method");
    }

}
