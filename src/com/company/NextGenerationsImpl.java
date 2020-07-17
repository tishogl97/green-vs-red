package com.company;

import com.company.contracts.GenerationZero;
import com.company.contracts.NextGenerations;
import com.company.contracts.TargetCell;

public class NextGenerationsImpl implements NextGenerations {

    private GenerationZero generationZero;
    private TargetCell targetCell;

    public NextGenerationsImpl(GenerationZero generationZero, TargetCell targetCell) {
        this.generationZero = generationZero;
        this.targetCell = targetCell;
    }

    public void nextGenerations() {
        int[][] grid = generationZero.consoleInput();
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        int[] target = targetCell.getTargetCell(maxRows, maxCols);
        int targetRow = target[0];
        int targetCol = target[1];
        int numberGenerations = target[2];
        int targetGreenTimes = 0;
        int[][] nextGeneration = copyGrid(grid);
        for (int generation = 0; generation <= numberGenerations; generation++) {
            if (grid[targetRow][targetCol] == 1) {
                targetGreenTimes = targetGreenTimes + 1;
            }
            for (int row = 0; row < maxRows; row++) {
                for (int col = 0; col < maxCols; col++) {
                    int currentCell = grid[row][col];
                    int greensAround = countGreensAround(grid, row, col);
                    if((greensAround == 3 || greensAround == 6) && currentCell == 0) {
                        nextGeneration[row][col] = 1;
                    } else if ((greensAround == 0 ||
                            greensAround == 1 ||
                            greensAround == 4 ||
                            greensAround == 5 ||
                            greensAround == 7 ||
                            greensAround == 8)
                            && currentCell == 1) {
                            nextGeneration[row][col] = 0;
                    } else {
                        nextGeneration[row][col] = currentCell;
                    }
                }
            }
            grid = copyGrid(nextGeneration);
        }
        System.out.printf("The cell on row: %d and column: %d was green in %d generations.", targetRow, targetCol, targetGreenTimes);
    }

    private int[][] copyGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] gridCopy = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            System.arraycopy(grid[row], 0, gridCopy[row], 0, cols);
        }
        return gridCopy;
    }

    private int countGreensAround(int[][] grid, int row, int col) {
        int greensAround = 0;
        greensAround = greensAround
                + topLeft(grid, row, col)
                + topCenter(grid, row, col)
                + topRight(grid, row, col)
                + right(grid, row, col)
                + left(grid, row, col)
                + bottomLeft(grid, row, col)
                + bottomCenter(grid, row, col)
                +bottomRight(grid, row, col);

        return greensAround;
    }

    private int topLeft(int[][] grid, int row, int col) {
        int topLeftRow = row - 1;
        int topLeftCol = col - 1;
        if (topLeftRow >= 0 && topLeftCol >= 0 && grid[topLeftRow][topLeftCol] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int topCenter(int[][] grid, int row, int col) {
        int topCenterRow = row - 1;
        if (topCenterRow >= 0 && grid[topCenterRow][col] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int topRight(int[][] grid, int row, int col) {
        int topRightRow = row - 1;
        int topRightCol = col + 1;
        int maxCols = grid[0].length;
        if (topRightRow >= 0 && topRightCol < maxCols && grid[topRightRow][topRightCol] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int right(int[][] grid, int row, int col) {
        int rightCol = col + 1;
        int maxCols = grid[0].length;
        if (rightCol < maxCols && grid[row][rightCol] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int left(int[][] grid, int row, int col) {
        int leftCol = col - 1;
        if (leftCol >= 0 && grid[row][leftCol] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int bottomLeft(int[][] grid, int row, int col) {
        int bottomLeftRow = row + 1;
        int bottomLeftCol = col - 1;
        int maxRows = grid.length;
        if (bottomLeftRow < maxRows && bottomLeftCol >= 0 && grid[bottomLeftRow][bottomLeftCol] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int bottomCenter(int[][] grid, int row, int col) {
        int bottomCenterRow = row + 1;
        int maxRows = grid.length;
        if (bottomCenterRow < maxRows && grid[bottomCenterRow][col] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int bottomRight(int[][] grid, int row, int col) {
        int bottomRightRow = row + 1;
        int bottomRightCol = col + 1;
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        if (bottomRightRow < maxRows && bottomRightCol < maxCols && grid[bottomRightRow][bottomRightCol] == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
