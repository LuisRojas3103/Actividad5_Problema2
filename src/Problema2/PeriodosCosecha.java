package Problema2;

import java.util.Objects;

public class PeriodosCosecha implements Comparable<PeriodosCosecha> {
    private String tiempoDeCosecha;
    private float cantidadDeCosecha;

    public PeriodosCosecha(String tiempoDeCosecha, float cantidadDeCosecha) {
        this.tiempoDeCosecha = tiempoDeCosecha;
        this.cantidadDeCosecha = cantidadDeCosecha;
    }

    public float obtenerCantidadEstimada() {
        return this.cantidadDeCosecha;
    }

    public String obtenerTiempoDeCosecha() {
        return this.tiempoDeCosecha;
    }

    @Override
    public String toString() {
        return "PeriodosCosecha{" +
                "tiempoDeCosecha='" + tiempoDeCosecha + '\'' +
                ", cantidadDeCosecha=" + cantidadDeCosecha +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PeriodosCosecha periodo)) return false;

        return Float.compare(periodo.cantidadDeCosecha, cantidadDeCosecha) == 0 &&
                Objects.equals(tiempoDeCosecha, periodo.tiempoDeCosecha);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(tiempoDeCosecha);
        result = 31 * result + Float.hashCode(cantidadDeCosecha);
        return result;
    }

    @Override
    public int compareTo(PeriodosCosecha o) {
        int r = 0;
        if ((r = this.tiempoDeCosecha.compareTo(o.tiempoDeCosecha)) != 0)
            return r;
        return Float.compare(this.cantidadDeCosecha, o.cantidadDeCosecha);
    }
}