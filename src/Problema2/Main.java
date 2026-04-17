package Problema2;

import java.util.ArrayList;
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

        System.out.println("--- PRUEBA DE IGUALDAD ---");
        System.out.println("¿f1 es igual a f2? (Mismo contenido): " + f1.equals(f2));
        System.out.println("¿f1 es igual a f3? (Diferente contenido): " + f1.equals(f3));
        System.out.println("Hash f1: " + f1.hashCode());
        System.out.println("Hash f2: " + f2.hashCode() + "\n");

        List<Fruta> lista = new ArrayList<>();
        lista.add(f1);
        lista.add(f3);
        lista.add(f4);

        System.out.println("--- LISTA DE FRUTAS REGISTRADAS ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }

        System.out.println("\n--- VALIDACIÓN DE INTERFACES ---");
        System.out.println("Comparando 'Aguacate' (f4) contra 'Mango' (f1):");
        int resNombre = f4.compareTo(f1);
        if (resNombre < 0) {
            System.out.println("Resultado: 'Aguacate' tiene prioridad alfabética.");
        } else {
            System.out.println("Resultado: 'Mango' tiene prioridad o son iguales.");
        }

        System.out.println("\nComparando 'Aguacate' (20.0 ha) contra 'Mango' (15.5 ha):");
        int resHectareas = Fruta.c.compare(f4, f1);
        if (resHectareas > 0) {
            System.out.println("Resultado: El Aguacate tiene mayor extensión de terreno.");
        } else {
            System.out.println("Resultado: El Mango tiene mayor o igual extensión.");
        }

        System.out.println("\n--- PRUEBA DE CÁLCULOS (Mango - Primavera) ---");
        System.out.println("Costo total del periodo: $" + f1.obtenerCostoTotalPeriodo(p1));
        System.out.println("Ganancia estimada: $" + f1.obtenerGananciaEstimada(p1));
    }
}