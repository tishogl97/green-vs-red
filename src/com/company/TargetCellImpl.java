package com.company;

import com.company.contracts.TargetCell;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TargetCellImpl implements TargetCell {

    private Scanner input;

    public TargetCellImpl(Scanner input) {
        this.input = input;
    }

    public int[] getTargetCell(int maxRow, int maxCol) {
        int[] targetCell = new int[3];
        boolean isValid = true;
        while(isValid) {
            System.out.print("Target cell row: ");
            targetCell[0] = input.nextInt();
            System.out.print("Target cell column: ");
            targetCell[1] = input.nextInt();
            isValid = checkCoordinates(targetCell[0], targetCell[1], maxRow, maxCol);
        }
        System.out.print("Number of generations: ");
        targetCell[2] = input.nextInt();
        //These are the Row, Column and Number of generations we want to follow the targeted cell
        return targetCell;
    }

    private boolean checkCoordinates(int row, int col, int maxRow, int maxCol) {
        if(row < maxRow && col < maxCol && row >= 0 && col >= 0) {
            return false;
        }
        System.out.printf("The cell row should be between 1 and %d and the cell column should between 1 and %d!%n", maxRow, maxCol);
        return true;
    }
}
