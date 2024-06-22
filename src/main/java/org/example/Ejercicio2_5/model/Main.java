package org.example.Ejercicio2_5.model;

import org.example.Ejercicio2_5.model.montecarlo.Cordenade;
import org.example.Ejercicio2_5.model.montecarlo.MonteCarlo;
import org.example.Ejercicio2_5.model.montecarlo.MonteCarloUtil;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double limit = 1.0;
        int numCordenades = 1000;
        MonteCarlo monteCarlo = new MonteCarlo(limit);
        Random random = new Random();

        for (int i = 0; i < numCordenades; i++) {
            double x = random.nextDouble() * limit;
            double y = random.nextDouble() * limit;
            Cordenade c = new Cordenade(x, y);
            monteCarlo.add(c);
        }
        double piAproximado = MonteCarloUtil.aproximarPi(monteCarlo);
        System.out.println("El valor aproximado de Pi es: " + piAproximado);
    }
}

