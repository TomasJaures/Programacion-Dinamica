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

   

    public static void printTableDP(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}