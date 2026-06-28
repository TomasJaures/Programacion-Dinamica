package com.example.Benchmarking;

public final class Timer {

    public static long get(Runnable r){
        long start = System.nanoTime();
        r.run();
        long end = System.nanoTime( );
        return end - start;
    }

    public static long getMedia(int times, Runnable r){
        long result = 0;
        for (int i = 0; i < times; i++) {
            long n = get(r);
            result+= n / times; //Se divide antes para no sobrepasar el long
        }
        return result;
    }

    public static void warmUp(int times, Runnable r){
        //Si el codigo es largo: (50 - 200)
        //Si el codigo es corto: (200 - 500)
        for (int i = 0; i < times; i++) {
            r.run();
        }
    }

}
