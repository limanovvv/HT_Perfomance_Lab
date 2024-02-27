package org.example;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

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

            List<Integer> list = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
                sum += list.get(count);
                max = Math.max(max, list.get(count));
                count++;
            }

            reader.close();

            int target = (int) Math.round((double) sum / count);
            int moves = 0;

            for (int j = 0; j < count; j++) {
                moves += Math.abs(target - list.get(j));
            }

            System.out.println("Min of steps: " + moves);

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
