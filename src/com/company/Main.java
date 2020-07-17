package com.company;

import com.company.contracts.GridGenerator;
import com.company.contracts.TargetCell;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GridGenerator gridGenerator = new GridGeneratorImpl(input);
        int[][] grid = gridGenerator.consoleInput();
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        TargetCell targetCell = new TargetCellImpl(input, maxRow, maxCol);
        targetCell.getTargetCell();
    }
}
