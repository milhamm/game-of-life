package dev.aang.gameoflife;

public enum Cell {
    LIVING_CELL("#"),
    DEAD_CELL("."),
    NEUTRAL_CELL("+");

    public final String label;

    Cell (String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
