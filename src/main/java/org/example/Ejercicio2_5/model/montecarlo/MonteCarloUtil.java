package org.example.Ejercicio2_5.model.montecarlo;

public class MonteCarloUtil {
    public static MonteCarlo copy(MonteCarlo monteCarlo) {
        MonteCarlo monte1 = new MonteCarlo(monteCarlo.getLimit());
        MonteCarlo monte2 = new MonteCarlo(monteCarlo.getLimit());

        while (!monteCarlo.isEmpty()) {
            Cordenade cordenade = monteCarlo.choose();
            monte1.add(cordenade);
            monte2.add(cordenade);
            monteCarlo.remove(cordenade);
        }
        while (!monte1.isEmpty()) {
            Cordenade cordenade = monte1.choose();
            monteCarlo.add(cordenade);
            monte1.remove(cordenade);
        }
        return monte2;
    }

    public static int size(MonteCarlo monteCarlo) {
        MonteCarlo monte1 = copy(monteCarlo);
        int i = 0;

        while (!monte1.isEmpty()) {
            Cordenade cordenade = monte1.choose();
            monte1.remove(cordenade);
            i++;
        }
        return i;
    }

    public static double aproximarPi(MonteCarlo monteCarlo) {
        int dentroDelCirculo = 0;
        MonteCarlo monte = copy(monteCarlo);

        while (!monte.isEmpty()) {
            Cordenade c = monte.choose();
            if (Math.pow(c.getx(), 2) + Math.pow(c.gety(), 2) <= Math.pow(monteCarlo.getLimit(), 2)) {
                dentroDelCirculo += 1;
            }
            monte.remove(c);
        }

        return 4.0 * dentroDelCirculo / size(monteCarlo);
    }
}
