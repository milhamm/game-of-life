package dev.aang.gameoflife;

public class Pattern {
    public static void createPattern(Grid grid, PatternName pattern){
        switch (pattern){
            case BLOCK:
                grid.addLivingCell(0, 0)
                        .addLivingCell(0,1)
                        .addLivingCell(1,0)
                        .addLivingCell(1,1);
                break;
            case GLIDER:
                grid.addLivingCell(0, 1)
                        .addLivingCell(1, 2)
                        .addLivingCell(2, 2)
                        .addLivingCell(2, 0)
                        .addLivingCell(2, 1);
                break;
            case BLINKER:
                grid.addLivingCell(2, 2)
                        .addLivingCell(1, 2)
                        .addLivingCell(3, 2);
                break;
            case GLIDER_GUN:
                grid.addLivingCell(1,5)
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
    }
}
