package org.example.Ejercicio3;
import java.util.Random;

public class GeneracionNumeroAleatorio {
    public int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}
