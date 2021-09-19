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

    public Grid initializeGrid(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell valueToBeInserted = getCurrentCell(i, j) != Cell.LIVING_CELL ? Cell.DEAD_CELL : Cell.LIVING_CELL;
                setCurrentCell(valueToBeInserted, i, j);
            }
        }
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

    public Cell getCurrentCell(int x, int y){
        return this.grid[x][y];
    }

    public void setCurrentCell(Cell value, int x, int y){
        this.grid[x][y] = value;
    }

}
