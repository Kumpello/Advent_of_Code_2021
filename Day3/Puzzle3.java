package com.AoC.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Puzzle3 {
    public static int getPowerConsumption() {
        File file = new File("src/com/AoC/Day3/input.txt");
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean firstRun = true;
        int mostUsedBits = 0;
        int leastUsedBits = 0;
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                char[] charBits = scanner.nextLine().toCharArray();
                int[] bits = new int[charBits.length];
                for (int i = 0; i < charBits.length; i++) {
                    bits[i] = Character.getNumericValue(charBits[i]);
                }

                if (firstRun) {
                    for (int i = 0; i < bits.length; i++) {
                        if (bits[i] > 0) {
                            arrayList.add(1);
                        } else {
                            arrayList.add(-1);
                        }
                    }
                    firstRun = false;
                } else {
                    for (int i = 0; i < bits.length; i++) {
                        if (bits[i] > 0) {
                            arrayList.set(i, arrayList.get(i) + 1);
                        } else {
                            arrayList.set(i, arrayList.get(i) - 1);
                        }
                    }
                }
            }
            StringBuilder mostUsed = new StringBuilder();
            StringBuilder leastUsed = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) > 0) {
                    mostUsed.append(1);
                    leastUsed.append(0);
                } else {
                    leastUsed.append(1);
                    mostUsed.append(0);
                }
            }
            mostUsedBits = Integer.parseInt(mostUsed.toString(), 2);
            leastUsedBits = Integer.parseInt(leastUsed.toString(), 2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mostUsedBits * leastUsedBits;
    }
}
