package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class PointPosition {
    public static void main(String[] args) {
        try {
            //парсим координаты центра окружности и радиус
            BufferedReader centerReader = new BufferedReader(new FileReader(args[0]));
            String[] centerCoordinates = centerReader.readLine().split(" ");
            double centerX = Double.parseDouble(centerCoordinates[0]);
            double centerY = Double.parseDouble(centerCoordinates[1]);
            double radius = Double.parseDouble(centerReader.readLine());
            centerReader.close();

            // парсим координаты точек
            BufferedReader pointsReader = new BufferedReader(new FileReader(args[1]));
            String pointCoordinates;
            while ((pointCoordinates = pointsReader.readLine()) != null) {
                String[] point = pointCoordinates.split(" ");
                double pointX = Double.parseDouble(point[0]);
                double pointY = Double.parseDouble(point[1]);

                // вычисляем расстояние от точки до центра окружности
                double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));

                // логика для определения положения точки относительно окружности
                if (distance == radius) {
                    System.out.println(0); 
                } else if (distance < radius) {
                    System.out.println(1); 
                } else {
                    System.out.println(2); 
                }
            }
            pointsReader.close();
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
