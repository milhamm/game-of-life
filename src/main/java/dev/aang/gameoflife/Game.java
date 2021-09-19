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
                int numberOfNeighbour = grid.countLivingNeighbour(i, j);
                if ((grid.isCurrentDeadCell(i, j) && numberOfNeighbour == 3) || (grid.isCurrentLivingCell(i, j) && numberOfNeighbour >= 2 && numberOfNeighbour <= 3)){
                    nextGrid.setCell(Cell.LIVING_CELL, i, j);
                } else {
                    nextGrid.setCell(Cell.DEAD_CELL, i, j);
                }
            }
        }

        grid = nextGrid;
    }

    public Game addPattern(PatternName patternName){
        Pattern.createPattern(this.grid, patternName);
        return this;
    }

    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
