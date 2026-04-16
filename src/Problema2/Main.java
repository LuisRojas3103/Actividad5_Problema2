package Problema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. CREACIÓN DE DATOS PARA PRUEBAS
        Fruta f1 = new Fruta("Mango", 15.5f, 5000.0f, 3500.0f);
        Fruta f2 = new Fruta("Mango", 15.5f, 5000.0f, 3500.0f); // Idéntica a f1
        Fruta f3 = new Fruta("Manzana", 10.0f, 6000.0f, 4000.0f);
        Fruta f4 = new Fruta("Aguacate", 20.0f, 12000.0f, 8000.0f);

        PeriodosCosecha p1 = new PeriodosCosecha("Primavera", 5.0f);
        f1.agregarPeriodo("Primavera", 5.0f);
        f3.agregarPeriodo("Verano", 3.5f);
        f4.agregarPeriodo("Otoño", 6.0f);

        // 2. PRUEBA DE IGUALDAD (equals y hashCode)
        System.out.println("--- PRUEBA DE IGUALDAD ---");
        System.out.println("¿f1 es igual a f2? (Mismo contenido): " + f1.equals(f2));
        System.out.println("¿f1 es igual a f3? (Diferente contenido): " + f1.equals(f3));
        System.out.println("Hash f1: " + f1.hashCode());
        System.out.println("Hash f2: " + f2.hashCode() + "\n");

        // 3. PRUEBA DE ORDENAMIENTO
        List<Fruta> lista = new ArrayList<>();
        lista.add(f1);
        lista.add(f3);
        lista.add(f4);

        System.out.println("--- LISTA ORIGINAL ---");
        lista.forEach(System.out::println);

        // Orden Natural (Nombre - Comparable)
        System.out.println("\n--- ORDEN NATURAL (Por Nombre) ---");
        Collections.sort(lista);
        lista.forEach(System.out::println);

        // Orden Alternativo (Hectáreas - Comparator)
        System.out.println("\n--- ORDEN ALTERNATIVO (Por Hectáreas) ---");
        lista.sort(Fruta.c);
        lista.forEach(System.out::println);

        // 4. PRUEBA DE CÁLCULOS
        System.out.println("\n--- PRUEBA DE CÁLCULOS (Mango - Primavera) ---");
        System.out.println("Costo total del periodo: $" + f1.obtenerCostoTotalPeriodo(p1));
        System.out.println("Ganancia estimada: $" + f1.obtenerGananciaEstimada(p1));
    }
}