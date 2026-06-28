package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Main.Item;

public class Main {


    final int cap = 20;
    static List<Item> list;

    static class Item {

        String name;
        int weight; //Despues a "double"
        int value;

        Item(String name, int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        //Input
        list = List.of(
            new Item("Agua", 2, 6),
            new Item("Medicamentos", 3, 8),
            new Item("Alimentos", 4, 7),
            new Item("Radio", 5, 10),
            new Item("Generador", 9, 15),
            new Item("Herramientas", 7, 12)
        );

        System.out.println("Hello world!");
    }
}