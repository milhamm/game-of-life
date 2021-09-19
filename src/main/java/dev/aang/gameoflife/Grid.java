package dev.aang.gameoflife;


public class Grid {

    public static final int OFFSET_GRID = 3;

    public Cell[][] grid;
    int gridSize;
    int offset;

    public Grid setGridSize(int gridSize){
        this.grid = new Cell[gridSize * OFFSET_GRID][gridSize * OFFSET_GRID];
        this.gridSize = gridSize;
        this.offset = ((gridSize * OFFSET_GRID - gridSize) / 2) - 1;
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

    public Grid addLivingCell(int x, int y){
        setCell(Cell.LIVING_CELL, x + offset, y + offset);
        return this;
    }

    public void displayGrid(){
        for (int i = offset; i < this.grid.length - offset - 2; i++) {
            for (int j = offset; j < this.grid[i].length - offset - 2; j++) {
                System.out.printf("%s ", getCell(j, i));
            }
            System.out.println();
        }
    }

    public int countLivingNeighbour(int x, int y){
        int numberOfNeighbour = 0;
        final int[][] moves = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

        for (int[] move: moves){
            int moveX = move[0] + x;
            int moveY = move[1] + y;

            if (isCurrentLivingCell(moveX, moveY)){
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
