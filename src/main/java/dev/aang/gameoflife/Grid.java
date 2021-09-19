package dev.aang.gameoflife;

public class Grid {

    public Cell[][] grid;

    public Grid(){
        this.grid = new Cell[5][5];
    }

    public Grid setGridSize(int gridSize){
        this.grid = new Cell[gridSize][gridSize];
        return this;
    }

    public void displayGrid(){
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                System.out.printf("%s ", getCurrentCell(i, j));
            }
            System.out.println();
        }
    }

    private Cell getCurrentCell(int x, int y){
        return this.grid[x][y];
    }

}
