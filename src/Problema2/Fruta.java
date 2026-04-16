package Problema2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Fruta implements Comparable<Fruta> {
    private String nombre;
    private float numeroDeHectareas;
    private float precioVenta;
    private float costoProduccion;
    private List<PeriodosCosecha> periodos;

    public static Comparator<Fruta> c = new Comparator<Fruta>() {
        @Override
        public int compare(Fruta o1, Fruta o2) {
            return Float.compare(o1.numeroDeHectareas, o2.numeroDeHectareas);
        }
    };

    public Fruta(String nombre, float numeroDeHectareas, float precioVenta, float costoProduccion) {
        this.nombre = nombre;
        this.numeroDeHectareas = numeroDeHectareas;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
        this.periodos = new ArrayList<>();
    }

    public void agregarPeriodo(String tiempoDeCosecha, float cantidadDeCosecha) {
        PeriodosCosecha nuevoPeriodo = new PeriodosCosecha(tiempoDeCosecha, cantidadDeCosecha);
        if (!this.periodos.contains(nuevoPeriodo)) {
            this.periodos.add(nuevoPeriodo);
        }
    }

    public void eliminarPeriodo(String tiempoDeCosecha) {
        this.periodos.removeIf(p -> p.obtenerTiempoDeCosecha().equalsIgnoreCase(tiempoDeCosecha));
    }

    public float obtenerCostoTotalPeriodo(PeriodosCosecha p) {
        return this.numeroDeHectareas * p.obtenerCantidadEstimada() * this.costoProduccion;
    }

    public float obtenerGananciaEstimada(PeriodosCosecha p) {
        float produccionTotal = this.numeroDeHectareas * p.obtenerCantidadEstimada();
        float margenGanancia = this.precioVenta - this.costoProduccion;
        return produccionTotal * margenGanancia;
    }

    public String obtenerNombre() { return nombre; }
    public float obtenerNumeroDeHectareas() { return numeroDeHectareas; }
    public float obtenerPrecioVenta() { return precioVenta; }
    public float obtenerCostoProduccion() { return costoProduccion; }
    public List<PeriodosCosecha> obtenerPeriodos() { return periodos; }

    @Override
    public String toString() {
        return "Fruta{" +
                "nombre='" + nombre + '\'' +
                ", numeroDeHectareas=" + numeroDeHectareas +
                ", precioVenta=" + precioVenta +
                ", costoProduccion=" + costoProduccion +
                ", periodos=" + periodos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fruta fruta)) return false;

        return Float.compare(fruta.numeroDeHectareas, numeroDeHectareas) == 0 && Float.compare(fruta.precioVenta, precioVenta) == 0
                && Float.compare(fruta.costoProduccion, costoProduccion) == 0 && Objects.equals(nombre, fruta.nombre) &&
                Objects.equals(periodos, fruta.periodos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + Float.hashCode(numeroDeHectareas);
        result = 31 * result + Float.hashCode(precioVenta);
        result = 31 * result + Float.hashCode(costoProduccion);
        result = 31 * result + Objects.hashCode(periodos);
        return result;
    }

    @Override
    public int compareTo(Fruta o) {
        int r = 0;
        if ((r = this.nombre.compareTo(o.nombre)) != 0)
            return r;
        if ((r = Float.compare(this.numeroDeHectareas, o.numeroDeHectareas)) != 0)
            return r;
        if ((r = Float.compare(this.precioVenta, o.precioVenta)) != 0)
            return r;
        return Float.compare(this.costoProduccion, o.costoProduccion);
    }
}