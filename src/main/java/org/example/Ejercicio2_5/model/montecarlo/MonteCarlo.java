package org.example.Ejercicio2_5.model.montecarlo;

public class MonteCarlo {
    private DynamicCordenadeSet cordenades;
    private double limit;

    public MonteCarlo(Double limit) {
        this.cordenades = new DynamicCordenadeSet();
        this.limit = limit;
    }

    public void add(Cordenade c) {
        if (c.getx() <= limit && c.gety() <= limit) {
            cordenades.add(c);
        }
    }

    public void remove(Cordenade c) {
        if (cordenades.isEmpty()) {
            throw new RuntimeException("No se pueden eliminar elementos de un MonteCarlo Vacío");
        }
        cordenades.remove(c);
    }

    public boolean isEmpty() {
        return cordenades.isEmpty();
    }

    public Cordenade choose() {
        return cordenades.choose();
    }

    public double getLimit() {
        return limit;
    }

    public DynamicCordenadeSet getCordenades() {
        return cordenades;
    }
}
