package org.example.Ejercicio3y4;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SimulacionTarea simulador = new SimulacionTarea();

        //Genera cuatro instancias de completableFuture para generar las cuatro tareas
        CompletableFuture<Integer> tarea1 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());
        CompletableFuture<Integer> tarea2 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());
        CompletableFuture<Integer> tarea3 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());
        CompletableFuture<Integer> tarea4 = CompletableFuture.supplyAsync(() -> simulador.simularTarea());

        //Espera a que termine cualquiera de las tareas
        CompletableFuture<Object> primeraEnFinalizar = CompletableFuture.anyOf(tarea1, tarea2, tarea3, tarea4);

        try {
            int resultado = (int) primeraEnFinalizar.get();

            System.out.println("Resultado de la primer tarea en finalizar: " + resultado);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
