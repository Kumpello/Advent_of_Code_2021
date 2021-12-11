package com.AoC.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2 {

    public static int getDirection() {
        File file = new File("src/com/AoC/Day2/input.txt");

        int horizontal = 0;
        int depth = 0;
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\s");
            while(scanner.hasNextLine()) {
                String direction = scanner.next();
                int currentNumber = Integer.parseInt(scanner.next());

                switch (direction) {
                    case "up":
                        depth -= currentNumber;
                        break;
                    case "down":
                        depth += currentNumber;
                        break;
                    case "forward":
                        horizontal += currentNumber;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return horizontal * depth;
    }
}
