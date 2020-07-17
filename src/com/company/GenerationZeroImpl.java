package com.company;

import com.company.contracts.GenerationZero;

import java.util.Scanner;

public class GenerationZeroImpl implements GenerationZero {

    private Scanner input;

    public GenerationZeroImpl(Scanner input) {
        this.input = input;
    }

    @Override
    public int[][] consoleInput() {
        int width = 0;
        int height = 0;
        boolean isCorrect = true;
        String[] gridLine = new String[0];
        while (isCorrect) {
            System.out.print("Grid width: ");
            width = Integer.parseInt(input.nextLine());
            System.out.print("Grid height: ");
            height = Integer.parseInt(input.nextLine());
            isCorrect = checkDimensions(height, width);
        }
        isCorrect = true;
        int[][] grid = new int[height][width];
        int linesLeft = height;

        for (int rows = 0; rows < height; rows++) {
            System.out.printf("Lines left untill the grid is complete => %d%n", linesLeft);
            linesLeft = linesLeft - 1;
            while(isCorrect) {
                gridLine = input.nextLine().split("");
                isCorrect = checkStringLength(width, gridLine.length);
            }

            isCorrect = true;
            for (int cols = 0; cols < width; cols++) {
                grid[rows][cols] = Integer.parseInt(gridLine[cols]);
            }
        }
        System.out.println("Grid Ready!");
        for (int rows = 0; rows < height; rows++) {
            for (int cols = 0; cols < width; cols++) {
                System.out.print(grid[rows][cols] + " ");
            }
            System.out.println();
        }
        return grid;
    }

    private boolean checkDimensions(int height, int width) {
        if (height > width || height > 999) {
            System.out.println("The width should be more than or equal to the height and both should be less than 1000");
            return true;
        }
        return false;
    }
    private boolean checkStringLength(int width, int length) {
        if(length != width) {
            System.out.printf("The length of the input should be %d characters!%nEnter line again: %n", width);
            return true;
        }
        return false;
    }
}


