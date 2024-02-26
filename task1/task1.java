package org.example;

import java.util.Arrays;

public class CircularArray
{
    public static void main( String[] args )
    {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] circularArray = new int[n];
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        int intervalStart = 0;

        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            path[i] = circularArray[intervalStart];
            intervalStart = (intervalStart + m - 1) % n;
        }

        System.out.println(Arrays.toString(path));

    }
}
