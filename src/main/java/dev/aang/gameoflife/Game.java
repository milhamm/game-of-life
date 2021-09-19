package dev.aang.gameoflife;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

    Grid grid;
    int gridSize;

    public Game(int gridSize){
        this.gridSize = gridSize;
        this.grid = new Grid().setGridSize(gridSize).initializeGrid();
    }

    public void start(){
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            clearConsole();
            evolve();
            grid.displayGrid();
        }, 0, 300, TimeUnit.MILLISECONDS);
    }

    private void evolve(){
        Grid nextGrid = new Grid();
        nextGrid.setGridSize(this.gridSize).initializeGrid();

        for (int i = 1; i < grid.getGridLength() - 1; i++) {
            for (int j = 1; j < grid.getGridLength() - 1; j++) {
                int numberOfNeighbour = grid.countNeighbour(i, j);
                if (grid.isCurrentDeadCell(i, j) && numberOfNeighbour == 3){
                    nextGrid.setCell(Cell.LIVING_CELL, i, j);
                } else if (grid.isCurrentLivingCell(i, j) && numberOfNeighbour >= 2 && numberOfNeighbour <= 3){
                    nextGrid.setCell(Cell.LIVING_CELL, i, j);
                } else {
                    nextGrid.setCell(Cell.DEAD_CELL, i, j);
                }
            }
        }

        grid = nextGrid;
    }

    public Game addLivingCell(int x, int y){
        this.grid.addLivingCell(x, y);
        return this;
    }

    public Game addPatterns(Pattern pattern){
        switch (pattern){
            case BLOCK:
                this.grid.addLivingCell(0, 0)
                        .addLivingCell(0,1)
                        .addLivingCell(1,0)
                        .addLivingCell(1,1);
                break;
            case GLIDER:
                this.grid.addLivingCell(0, 1)
                        .addLivingCell(1, 2)
                        .addLivingCell(2, 2)
                        .addLivingCell(2, 0)
                        .addLivingCell(2, 1);
                break;
            case BLINKER:
                this.grid.addLivingCell(2, 2)
                        .addLivingCell(1, 2)
                        .addLivingCell(3, 2);
                break;
            case GLIDER_GUN:
                this.grid.addLivingCell(1,5)
                        .addLivingCell(1,6)
                        .addLivingCell(2, 5)
                        .addLivingCell(2,6)
                        .addLivingCell(11, 5)
                        .addLivingCell(11, 6)
                        .addLivingCell(11, 7)
                        .addLivingCell(12, 4)
                        .addLivingCell(12, 8)
                        .addLivingCell(13, 3)
                        .addLivingCell(13, 9)
                        .addLivingCell(14, 3)
                        .addLivingCell(14, 9)
                        .addLivingCell(15, 6)
                        .addLivingCell(16, 4)
                        .addLivingCell(16, 8)
                        .addLivingCell(17, 5)
                        .addLivingCell(17, 6)
                        .addLivingCell(17, 7)
                        .addLivingCell(18, 6)
                        .addLivingCell(21, 3)
                        .addLivingCell(21, 4)
                        .addLivingCell(21, 5)
                        .addLivingCell(22, 3)
                        .addLivingCell(22, 4)
                        .addLivingCell(22, 5)
                        .addLivingCell(23, 2)
                        .addLivingCell(23, 6)
                        .addLivingCell(25, 1)
                        .addLivingCell(25, 2)
                        .addLivingCell(25, 6)
                        .addLivingCell(25, 7)
                        .addLivingCell(35, 3)
                        .addLivingCell(35, 4)
                        .addLivingCell(36, 3)
                        .addLivingCell(36, 4);
        }
        return this;
    }

    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
