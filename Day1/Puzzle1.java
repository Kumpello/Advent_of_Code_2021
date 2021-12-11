package com.AoC.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle1 {
    static File file = new File("src/com/AoC/Day2/input.txt/input.txt");

    public static int getIncrements() {

        int increments = -1;
        try {
            int lastNumber = 0;
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextInt()) {
                int currentNumber = scanner.nextInt();
                if (increments == -1) {
                    lastNumber = currentNumber;
                    increments = 0;
                } else {
                    if (currentNumber > lastNumber) {
                        increments++;
                    }
                    lastNumber = currentNumber;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return increments;
    }

    public static int getIncrements2() {
        int increments = -1;

        try {
            int lastNumber[] = new int[3];
            Scanner scanner = new Scanner(file);
            int lastNumberAv = 0;
            int currentNumber[] = new int[3];
            int currentNumberAv = 0;
            while(scanner.hasNextInt()) {
                if (increments == -1) {
                    for (int i = 0; i < 4; i++) {
                        for (int ii = 0; ii < 3; ii++) {
                            if (scanner.hasNextInt()) {
                                int temp = scanner.nextInt();
                                lastNumberAv += temp;
                                lastNumber[ii] = temp;
                                if (ii < 2) {
                                    currentNumber[ii + 1] = temp;
                                    currentNumberAv++;
                                }
                            }
                        }

                    }
                    currentNumber[currentNumber.length - 1] = scanner.nextInt();
                    currentNumberAv++;
                    lastNumberAv = lastNumberAv / currentNumber.length;
                    currentNumberAv = currentNumberAv / currentNumber.length;

                    increments = 0;
                } else {
                    lastNumber[0] = currentNumber[1];
                    lastNumber[2] = currentNumber[2];
                    if (scanner.hasNextInt()) {
                        currentNumber[0] = scanner.nextInt();
                    }
                    lastNumber[2] = currentNumber[0];
                    for (int i = 1; i < 3; i++) {
                        if (scanner.hasNextInt()) {
                            currentNumber[i] = scanner.nextInt();
                        }
                    }
                    if(currentNumberAv > lastNumberAv) {
                        increments++;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return increments;
    }

}
