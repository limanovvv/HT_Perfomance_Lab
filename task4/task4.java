package org.example;

import java.io.FileReader;
import java.io.BufferedReader;

public class MinOfSteps {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("A mistake when entering the argument");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                sum += num;
                max = Math.max(max, num);
                count++;
            }

            reader.close();

            int target = (int) Math.round((double) sum / count);
            int moves = 0;

            for (int i = 0; i < count; i++) {
                moves += Math.abs(target - Integer.parseInt(line));
            }

            System.out.println("Min of steps: " + moves);

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
