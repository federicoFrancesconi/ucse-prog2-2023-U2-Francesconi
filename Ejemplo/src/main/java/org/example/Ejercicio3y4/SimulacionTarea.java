package org.example.Ejercicio3y4;

public class SimulacionTarea {
    public int simularTarea() {
        try {
            //Espera para simular que hace algo
            Thread.sleep(1000 + (int) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Genera un numero aleatorio entre 100 y 500
        GeneracionNumeroAleatorio generador = new GeneracionNumeroAleatorio();
        return generador.generarNumeroAleatorio(100, 500);
    }
}
