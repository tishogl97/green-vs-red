package com.company;

import com.company.contracts.GenerationZero;
import com.company.contracts.NextGenerations;
import com.company.contracts.TargetCell;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GenerationZero generationZero = new GenerationZeroImpl(input);
        TargetCell targetCell = new TargetCellImpl(input);
        NextGenerations nextGenerations = new NextGenerationsImpl(generationZero, targetCell);
        nextGenerations.nextGenerations();
    }
}
