package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static class Item {

        String name;
        int weight; //Despues a "double"
        int value;

        Item(String name, int weight, int value){
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        final int cap = 20;

        //Input
        List<Item> items = List.of(
            new Item("Agua", 2, 6),
            new Item("Medicamentos", 3, 8),
            new Item("Alimentos", 4, 7),
            new Item("Radio", 5, 10),
            new Item("Generador", 9, 15),
            new Item("Herramientas", 7, 12)
        );

        int dp[][] = createTableDP(items, cap);
        createReport(items, cap, dp);
    }

    public static int[][] createTableDP(List<Item> items, int cap){
        int n = items.size() + 1;
        int[][] dp = new int[n][cap + 1];

        for (int i = 1; i < n; i++) {
            Item currentItem = items.get(i - 1);

            for (int w = 0; w <= cap; w++) {
                if (currentItem.weight <= w) { //Para que no se salga de la tabla DP
                    dp[i][w] = Math.max(
                        dp[i-1][w],
                        currentItem.value + dp[i-1][w-currentItem.weight]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp;
    }

     public static void createReport(List<Item> items, int cap, int[][] dp) {
        int n = items.size();

        //Agregar a la mochila
        int x = n;
        int y = cap;
        List<Item> bp = new ArrayList<>();

        while (x > 0 && y > 0) {
            if (dp[x][y] == dp[x - 1][y]) {
                //System.out.println("Descartado: " + items.get(x - 1).name);
                x--;
            } else {
                //System.out.println("Seleccionado: " + items.get(x - 1).name);
                bp.add(items.get(x - 1));
                y -= items.get(x - 1).weight;
                x--;
            }
        }

        int sumW = 0;
        System.out.println("Items seleccionados: ");
        for (Item item : bp) {
            
            sumW += item.weight;
            System.out.println("- " + item.name);
        }
        System.out.println("\nPeso sumado: (" + sumW + " / " + cap + ")");
        System.out.println("Valor maximo alcanzado: " + dp[n][cap]);

        y = n;
        x = cap;
        //Formatear Table DP (toString)
        
        printTableDP(items, cap, dp);
    }
   

    public static void printTableDP(List<Item> items, int cap, int[][] dp){
        System.out.println("==================================== TABLA DP =====================================");
        int n = items.size() - 1;

        //Linea "0 0 0 0 0 0 0 0 0 0 0 0 ... (Sin item)"
        System.out.print(String.format("%-20s", "No item: "));
        for (int i = 0; i < dp[0].length; i++) {
            System.out.print(String.format("%-3s", dp[0][i]));
        }
        System.out.println();

        //Siguientes lineas:
        for (int i = 1; i < dp.length; i++) {
            System.out.print(String.format("%-20s", items.get(n - i + 1).name + ": "));
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(String.format("%-3s", dp[i][j]));
            }
            System.out.println();
            //System.out.println(Arrays.toString(dp[i]));
        }
        System.out.print("===================================================================================");
    }
}

/*

[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6]
[0, 0, 6, 8, 8, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14]
[0, 0, 6, 8, 8, 14, 14, 15, 15, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21]
[0, 0, 6, 8, 8, 14, 14, 16, 18, 21, 24, 24, 25, 25, 31, 31, 31, 31, 31, 31, 31]
[0, 0, 6, 8, 8, 14, 14, 16, 18, 21, 24, 24, 25, 25, 31, 31, 31, 33, 36, 39, 39]
[0, 0, 6, 8, 8, 14, 14, 16, 18, 21, 24, 24, 26, 26, 31, 31, 33, 36, 36, 39, 39]
*/