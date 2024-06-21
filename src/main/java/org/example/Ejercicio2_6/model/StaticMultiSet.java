package org.example.Ejercicio2_6.model;

import java.util.Random;

public class StaticMultiSet implements MultiSet {

    private static final int MAX = 10000;
    private int[] elementos; // se almacenan los elementos del conjunto
    private int[] veces; // se almacenan las veces que aparece cada elemento
    private int count;

    public StaticMultiSet() {
        this.elementos = new int[MAX];
        this.veces = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        for (int i = 0; i < count; i++) {
            if (this.elementos[i] == a) {
                this.veces[i]++;
                return;
            }
        }
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        this.elementos[count] = a;
        this.veces[count] = 1;
        this.count++;
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < count; i++) {
            if (this.elementos[i] == a) {
                this.veces[i]--;
                if (this.veces[i] == 0) {
                    for (int j = i; j < count - 1; j++) {
                        this.elementos[j] = this.elementos[j + 1];
                        this.veces[j] = this.veces[j + 1];
                    }
                    this.count--;
                }
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.elementos[randomIndex];
    }

    @Override
    public int count(int a) {
        for (int i = 0; i < count; i++) {
            if (this.elementos[i] == a) {
                return this.veces[i];
            }
        }
        return 0;
    }
}
