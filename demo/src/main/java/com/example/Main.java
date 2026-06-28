package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.Backpack.BPSolver;
import com.example.Backpack.Item;
import com.example.Benchmarking.Timer;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== CASO A ==========");
        //caseA();
        System.out.println("============================\n\n");

        System.out.println("========== EXPERIMENTO ==========\n\n");
        executeExperiment();
        System.out.println("=================================\n\n");


    }

    public static void caseA(){
        List<Item> items = List.of(
            new Item("Agua", 2, 6),
            new Item("Medicamentos", 3, 8),
            new Item("Alimentos", 4, 7),
            new Item("Radio", 5, 10),
            new Item("Generador", 9, 15),
            new Item("Herramientas", 7, 12)
        );

        BPSolver.run(items, 20);
        BPSolver.printReport();

    }

    public static void executeExperiment() {
        int[] sizes = {10, 20, 50, 100, 200};

        for (int size : sizes) {
            int capacity = size * 5; //Cantidad proporcional
            List<Item> items = generateItems(size);

            //Warm up para obtener datos mas reales:
            Timer.warmUp(10000, () -> BPSolver.run(items, capacity));

            long totalTimeNs = Timer.getMedia(30, () -> BPSolver.run(items, capacity));

            int rows = size + 1;
            int cols = capacity + 1;
            int matrixSize = rows * cols;

            System.out.println("[!]====== " + size + " ITEMS =====[!]");
            System.out.println("Cantidad de items: " + size);
            System.out.println("Capacidad de la mochila: " + capacity);
            System.out.println("Tiempo de ejecucion: " + totalTimeNs + " ns (" + (totalTimeNs / 1_000_000.0) + " ms)");
            System.out.println("Dimensiones de la matriz: " + rows + "x" + cols + " (Total de celdas: " + matrixSize + ")");
            System.out.println("Valor optima encontrado: " + BPSolver.getMaxValue());
            System.out.println();
        }
    }

    public static List<Item> generateItems(int size) {
        Random r = new Random();
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= size; i++) {

            String name = "Item_" + i;
            int weight = r.nextInt(10) + 1; // Pesos entre 1 y 10
            int value = r.nextInt(100) + 10; // Valores entre 10 y 110
            items.add(new Item(name, weight, value));

        }

        return items;
    }
    
}