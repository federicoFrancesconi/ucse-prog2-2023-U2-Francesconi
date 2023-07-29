package org.example.Ejercicio3y4;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Ejercicio3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SimulacionTarea simulador = new SimulacionTarea();

        //Genera cuatro instancias de completableFuture para generar las cuatro tareas
        CompletableFuture<Integer> tarea1 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());
        CompletableFuture<Integer> tarea2 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());
        CompletableFuture<Integer> tarea3 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());
        CompletableFuture<Integer> tarea4 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());

        //Espera a que terminen las cuatro tareas
        CompletableFuture<Void> tareas = CompletableFuture.allOf(tarea1, tarea2, tarea3, tarea4);

        //Uso un callback para obtener el resultado de las tareas
        CompletableFuture<Void> resultFuture = tareas.thenRun(() -> {
            try {
                int result1 = tarea1.get();
                int result2 = tarea2.get();
                int result3 = tarea3.get();
                int result4 = tarea4.get();

                int sumaResultados = result1 + result2 + result3 + result4;

                System.out.println("Suma de los valores generados por las tareas: " + sumaResultados);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        //Se asegura de que todas las tareas hayan terminado
        resultFuture.get();
    }
}

