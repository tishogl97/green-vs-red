package com.company;

import com.company.contracts.TargetCell;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TargetCellImpl implements TargetCell {

    private Scanner input;
    private int maxRow;
    private int maxCol;

    public TargetCellImpl(Scanner input, int maxRow, int maxCol) {
        this.input = input;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
    }

    public int[] getTargetCell() {
        int[] targetCell = new int[3];
        boolean isValid = true;
        while(isValid) {
            System.out.print("Target cell row: ");
            // Removing 1, because the user will not need to set the row to 0 if he wants the 1st row
            targetCell[0] = input.nextInt() - 1;
            System.out.print("Target cell column: ");
            targetCell[1] = input.nextInt() - 1;
            isValid = checkCoordinates(targetCell[0], targetCell[1]);
        }
        System.out.print("Number of generations: ");
        targetCell[2] = input.nextInt();
        //These are the Row, Column and Number of generations we want to follow the targeted cell
        return targetCell;
    }

    private boolean checkCoordinates(int row, int col) {
        if(row < maxRow && col < maxCol && row > 0 && col > 0) {
            return false;
        }
        System.out.printf("The cell row should be between 1 and %d and the cell column should between 1 and %d!%n", maxRow, maxCol);
        return true;
    }
}
