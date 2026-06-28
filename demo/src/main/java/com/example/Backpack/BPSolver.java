package com.example.Backpack;

import java.util.ArrayList;
import java.util.List;

public final class BPSolver {
    
    private static int cap; //Capacidad maxima
    private static List<Item> items;
    
    private static int maxValue;
    private static List<Item> selectedItems;
    private static int dp[][];

    public static void run(List<Item> items, int cap){
        BPSolver.items = items;
        BPSolver.cap = cap;
        
        createTableDP();
    }

    public static void printReport() {
        printTableDP(dp); //Imprimir tabla DP y sus respectivos objetos
        List<Item> bp = putInBackpack(dp); //Seleccionar items que iran a la "mochila"
        
        getBackpackData(bp); //Peso y valor total
    }

    public static void createTableDP(){
        // Se necesita 1 columna y fila mas para los casos base (Sin item y sin capacidad)
        int n = items.size() + 1;
        int[][] dp = new int[n][cap + 1];

        for (int i = 1; i < n; i++) { //Se salta el caso base de Sin Items
            Item currentItem = items.get(i - 1);
            for (int w = 0; w <= cap; w++) {
                if (currentItem.weight <= w) { //Invalidar IndexOutOfBounds de la tabla DP
                    // Se decide si añadir o no el valor del nuevo elemento
                    dp[i][w] = Math.max(
                        dp[i-1][w],
                        currentItem.value + dp[i-1][w-currentItem.weight]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        BPSolver.dp = dp;
    }

    public static List<Item> putInBackpack(int[][] dp){
        int n = items.size();
        List<Item> bp = new ArrayList<>();

        int x = n;
        int y = cap;
        
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

        selectedItems = bp;

        return bp;
    }

    public static void getBackpackData(List<Item> bp){
        int n = items.size();
        int sumW = 0;
        System.out.println("\n\nItems seleccionados: ");
        for (Item item : bp) {
            sumW += item.weight;
            System.out.println("- " + item.name);
        }
        System.out.println("\nPeso sumado: (" + sumW + " / " + cap + ")");
        System.out.println("Valor maximo alcanzado: " + dp[n][cap]);
    }

    /**
     * Fila: Objetos
     * Columna: Capacidad
     * Celda: VALOR acumulado de la mochila
     */
    public static void printTableDP(int[][] dp){
        
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

    public static List<Item> getSelectedItems() {
        return selectedItems;
    }

    public static int getMaxValue() {
        return dp[items.size()][cap];
    }

    public static int[][] getDp() {
        return dp;
    }

}
