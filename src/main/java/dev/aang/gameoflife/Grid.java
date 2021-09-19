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
                Cell valueToBeInserted = getCell(i, j) != Cell.LIVING_CELL ? Cell.DEAD_CELL : Cell.LIVING_CELL;
                setCell(valueToBeInserted, i, j);
            }
        }
        return this;
    }

    public Grid addLivingCell(int x, int y){
        setCell(Cell.LIVING_CELL, x, y);
        return this;
    }

    public void displayGrid(){
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                System.out.printf("%s ", getCell(i, j));
            }
            System.out.println();
        }
    }

    public int countCurrentNeighbour(int x, int y){
        int numberOfNeighbour = 0;
        final int[][] moves = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

        for (int[] move: moves){
            int moveX = move[0] + x;
            int moveY = move[1] + y;

            if (getCell(moveX, moveY) == Cell.DEAD_CELL){
                numberOfNeighbour ++;
            }
        }

        return numberOfNeighbour;
    }

    public Cell getCell(int x, int y){
        return this.grid[x][y];
    }

    public void setCell(Cell value, int x, int y){
        this.grid[x][y] = value;
    }

}
