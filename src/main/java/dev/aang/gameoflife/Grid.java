package dev.aang.gameoflife;

import java.util.function.Consumer;

interface Callback{
    void call(int i, int j);
}

public class Grid {

    public static final int OFFSET_GRID = 2;

    public Cell[][] grid;

    public Grid(){
        this.grid = new Cell[6 * OFFSET_GRID][6 * OFFSET_GRID];
    }

    public Grid setGridSize(int gridSize){
        this.grid = new Cell[gridSize * OFFSET_GRID][gridSize * OFFSET_GRID];
        return this;
    }

    public Grid initializeGrid(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                setCell(Cell.DEAD_CELL, i, j);
            }
        }
        return this;
    }

    public void addLivingCell(int x, int y){
        setCell(Cell.LIVING_CELL, x + OFFSET_GRID, y + OFFSET_GRID);
    }

    public void displayGrid(){
        iterateInnerGrid((x, y) -> {
            System.out.printf("%s ", getCell(y, x));
        });
    }

    public int countNeighbour(int x, int y){
        int numberOfNeighbour = 0;
        final int[][] moves = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

        for (int[] move: moves){
            int moveX = move[0] + x;
            int moveY = move[1] + y;

            if (getCell(moveX, moveY) == Cell.LIVING_CELL){
                numberOfNeighbour ++;
            }
        }

        return numberOfNeighbour;
    }

    public void iterateInnerGrid(Callback callback){
        for (int i = OFFSET_GRID; i < this.grid.length - OFFSET_GRID - 2; i++) {
            for (int j = OFFSET_GRID; j < this.grid[i].length - OFFSET_GRID - 2; j++) {
                callback.call(i, j);
            }
            System.out.println();
        }
    }

    public Cell getCell(int x, int y){
        return this.grid[x][y];
    }

    public void setCell(Cell value, int x, int y){
        this.grid[x][y] = value;
    }

    public int getGridLength(){
        return this.grid.length;
    }

    public boolean isCurrentLivingCell(int x, int y){
        return getCell(x, y) == Cell.LIVING_CELL;
    }

    public boolean isCurrentDeadCell(int x, int y){
        return getCell(x, y) == Cell.DEAD_CELL;
    }

}
