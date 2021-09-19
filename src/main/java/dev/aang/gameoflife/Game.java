package dev.aang.gameoflife;

public class Game {

    Grid grid = new Grid();

    public void start(){
        grid.setGridSize(20)
                .initializeGrid()
                .addLivingCell(2, 0)
                .addLivingCell(2, 1)
                .addLivingCell(2, 2)
                .addLivingCell(1, 2)
                .addLivingCell(0, 1);

        for (int i = 0; i < 10; i++) {
            evolve();
            grid.displayGrid();
        }
    }

    private void evolve(){
        Grid nextGrid = new Grid();
        nextGrid.setGridSize(20).initializeGrid();

        for (int i = 1; i < grid.getGridLength() - 1; i++) {
            for (int j = 1; j < grid.getGridLength() - 1; j++) {
                int numberOfNeighbour = grid.countNeighbour(i, j);
                if (grid.getCell(i, j) == Cell.DEAD_CELL && numberOfNeighbour == 3){
                    nextGrid.setCell(Cell.LIVING_CELL, i, j);
                } else if (grid.getCell(i, j) == Cell.LIVING_CELL && numberOfNeighbour >= 2 && numberOfNeighbour <= 3){
                    nextGrid.setCell(Cell.LIVING_CELL, i, j);
                } else {
                    nextGrid.setCell(Cell.DEAD_CELL, i, j);
                }
            }
        }

        grid = nextGrid;
    }
}
