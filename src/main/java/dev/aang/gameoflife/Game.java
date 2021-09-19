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
        executorService.scheduleAtFixedRate(()->{
            clearConsole();
            evolve();
            grid.displayGrid();
        }, 0, 1, TimeUnit.SECONDS);
    }

    private void evolve(){
        Grid nextGrid = new Grid();
        nextGrid.setGridSize(20).initializeGrid();

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

    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
